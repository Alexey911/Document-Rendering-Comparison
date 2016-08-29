package com.zhytnik.benchmark.ghost4j;

import com.zhytnik.benchmark.common.Reader;
import com.zhytnik.benchmark.test.Benchmark;

import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class Ghost4JReaderBenchmark extends Benchmark {
    @Override
    protected Reader<InputStream> getReader() {
        return new Ghost4JReader();
    }
}
