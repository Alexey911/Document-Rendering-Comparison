package com.zhytnik.converter.benchmark;

import com.zhytnik.converter.common.Converter;
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
 * @since 15-Sep-16
 */
@State(Scope.Benchmark)
@SuppressWarnings({"unchecked", "unused"})
class Benchmarks {

    InputStream data;

    Converter converter = null;

    @Setup(Invocation)
    public void setUp() throws IOException {
        data = null; /*load document*/
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @OutputTimeUnit(TimeUnit.SECONDS)
    @Warmup(iterations = 20)
    @Measurement(iterations = 10)
    public void benchmark(Blackhole bh) throws Exception {
        bh.consume(converter.convert(data));
    }

    void run() throws RunnerException {
        final ChainedOptionsBuilder options = new OptionsBuilder()
                .include(Benchmarks.class.getCanonicalName())
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
        new Runner(setUp(options)).run();
    }

    protected static Options setUp(ChainedOptionsBuilder options) {
        return options.build();
    }
}