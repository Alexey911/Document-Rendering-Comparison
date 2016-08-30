package com.zhytnik.benchmark.apachepoi.slideshow;

import com.zhytnik.benchmark.common.Reader;
import com.zhytnik.benchmark.test.ReaderTest;

import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 30-Aug-16
 */
public class PPTToImageConverterTest extends ReaderTest {

    @Override
    protected String getResource() {
        return PPT_RESOURCE;
    }

    @Override
    protected Reader<InputStream> getReader() {
        return new PPTToImageConverter();
    }
}
