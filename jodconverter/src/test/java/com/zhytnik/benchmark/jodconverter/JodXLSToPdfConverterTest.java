package com.zhytnik.benchmark.jodconverter;


import com.zhytnik.benchmark.common.FlowConverter;
import com.zhytnik.benchmark.test.FlowConverterTest;

import java.io.InputStream;

import static com.zhytnik.benchmark.test.Resources.XLS_RESOURCE;

/**
 * @author Alexey Zhytnik
 * @since 31-Aug-16
 */
public class JodXLSToPdfConverterTest extends FlowConverterTest {

    @Override
    protected String getResource() {
        return XLS_RESOURCE;
    }

    @Override
    protected FlowConverter<InputStream> getConverter() {
        return new JodXLSToPdfConverter();
    }
}