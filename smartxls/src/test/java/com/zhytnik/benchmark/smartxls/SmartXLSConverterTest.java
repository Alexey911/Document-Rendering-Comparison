package com.zhytnik.benchmark.smartxls;

import com.zhytnik.benchmark.common.FlowConverter;
import com.zhytnik.benchmark.test.FlowConverterTest;

import java.io.InputStream;

import static com.zhytnik.benchmark.test.Resources.XLS_RESOURCE;

/**
 * @author Alexey Zhytnik
 * @since 01.09.2016
 */
public class SmartXLSConverterTest extends FlowConverterTest {

    @Override
    protected String getResource() {
        return XLS_RESOURCE;
    }

    @Override
    protected FlowConverter<InputStream> getConverter() {
        return new SmartXLSConverter();
    }
}