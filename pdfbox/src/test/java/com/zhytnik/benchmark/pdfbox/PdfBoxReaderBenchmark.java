package com.zhytnik.benchmark.pdfbox;

import com.zhytnik.benchmark.common.Reader;
import com.zhytnik.benchmark.test.Benchmark;
import org.openjdk.jmh.runner.options.ChainedOptionsBuilder;
import org.openjdk.jmh.runner.options.Options;

import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class PdfBoxReaderBenchmark extends Benchmark {

    private static final String FAST_KCMS = "-Dsun.java2d.cmm=sun.java2d.cmm.kcms.KcmsServiceProvider";

    @Override
    protected Options setUp(ChainedOptionsBuilder options) {
        return options.jvmArgsAppend(FAST_KCMS).build();
    }

    @Override
    protected Reader<InputStream> getReader() {
        return new PdfBoxReader();
    }
}
