package com.zhytnik.benchmark.documents4j;

import com.zhytnik.benchmark.common.FlowConverter;
import com.zhytnik.benchmark.test.FlowConverterTest;

import java.io.InputStream;

import static com.zhytnik.benchmark.test.Resources.DOCX_RESOURCE;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class Docs4jDocxToPdfConverterTest extends FlowConverterTest {

    @Override
    protected String getResource() {
        return DOCX_RESOURCE;
    }

    @Override
    protected FlowConverter<InputStream> getConverter() {
        return new Docs4jDocxToPdfConverter();
    }
}
