package com.zhytnik.benchmark.test;

import com.zhytnik.benchmark.common.Reader;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.profile.HotspotMemoryProfiler;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import static org.openjdk.jmh.annotations.Level.Invocation;

/**
 * @author Alexey Zhytnik
 * @since 25-Aug-16
 */

@State(Scope.Benchmark)
public abstract class Benchmarks {

    @State(Scope.Benchmark)
    public static class Single {
        int from = 0, to = 1;
    }

    @State(Scope.Benchmark)
    public static class Interval {
        int from = 0, to = 3;
    }

    Reader<InputStream> reader = getReader();
    InputStream data = ResourceLoader.load("test.pdf");

    @TearDown(Invocation)
    public void tearDown() throws IOException {
        data.reset();
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Warmup(time = 5, iterations = 14)
    @Measurement(iterations = 6)
    public void readSingle(Blackhole bh, Single range) throws Exception {
        bh.consume(reader.read(data, range.from, range.to));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Warmup(time = 5, iterations = 14)
    @Measurement(iterations = 6)
    public void readInterval(Blackhole bh, Interval range) throws Exception {
        bh.consume(reader.read(data, range.from, range.to));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Warmup(iterations = 14)
    @Measurement(iterations = 6)
    public void readPageCount(Blackhole bh) throws Exception {
        bh.consume(reader.pageCount(data));
    }

    @Test
    public void runsBenchmarks() {
        final ChainedOptionsBuilder options = new OptionsBuilder()
                .include(this.getClass().getCanonicalName())
                .shouldDoGC(true)
                .forks(1)
                .addProfiler(GCProfiler.class)
                .addProfiler(HotspotMemoryProfiler.class)
                .jvmArgs(
                        "-server",
                        "-Xms512m",
                        "-Xmx1536m",
                        "-XX:+UseG1GC",
                        "-XX:+UseCompressedOops"
                );
        run(setUp(options));
    }

    protected Options setUp(ChainedOptionsBuilder options) {
        return options.build();
    }

    private void run(Options options) {
        try {
            new Runner(options).run();
        } catch (RunnerException e) {
            e.printStackTrace();
        }
    }

    protected abstract Reader<InputStream> getReader();
}
