package com.zhytnik.benchmark.documents4j;

import com.zhytnik.benchmark.common.FlowConverter;

import java.io.InputStream;

import static com.zhytnik.benchmark.test.Resources.XLS_RESOURCE;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class Docs4jExcelToPdfConverterTest extends Docs4jConverterTest {

    @Override
    protected String getResource() {
        return XLS_RESOURCE;
    }

    @Override
    protected FlowConverter<InputStream> getConverter() {
        return new Docs4jExcelToPdfConverter();
    }
}