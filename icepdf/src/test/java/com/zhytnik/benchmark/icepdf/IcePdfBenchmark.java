package com.zhytnik.benchmark.icepdf;

import com.zhytnik.benchmark.common.Reader;
import com.zhytnik.benchmark.test.Benchmarks;

import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class IcePdfBenchmark extends Benchmarks {
    @Override
    protected Reader<InputStream> getReader() {
        return new IcePdfReader();
    }
}
