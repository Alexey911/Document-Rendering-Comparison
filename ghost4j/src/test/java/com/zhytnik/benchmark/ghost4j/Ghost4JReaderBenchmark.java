package com.zhytnik.benchmark.ghost4j;

import com.zhytnik.benchmark.common.Reader;
import com.zhytnik.benchmark.test.Benchmarks;

import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class Ghost4JReaderBenchmark extends Benchmarks {
    @Override
    protected Reader<InputStream> getReader() {
        return new Ghost4JReader();
    }
}
