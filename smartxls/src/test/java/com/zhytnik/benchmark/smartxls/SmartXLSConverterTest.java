package com.zhytnik.benchmark.smartxls;

import com.zhytnik.benchmark.common.Reader;
import com.zhytnik.benchmark.test.ReaderTest;

import java.io.InputStream;

import static com.zhytnik.benchmark.test.Resources.XLS_RESOURCE;

/**
 * @author Alexey Zhytnik
 * @since 01.09.2016
 */
public class SmartXLSConverterTest extends ReaderTest {

    @Override
    protected String getResource() {
        return XLS_RESOURCE;
    }

    @Override
    protected Reader<InputStream> getReader() {
        return new SmartXLSConverter();
    }
}