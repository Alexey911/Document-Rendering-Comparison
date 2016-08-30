package com.zhytnik.benchmark.apachepoi.doc;

import com.zhytnik.benchmark.common.FlowConverter;
import com.zhytnik.benchmark.test.FlowConverterTest;

import java.io.InputStream;

import static com.zhytnik.benchmark.test.Resources.DOC_RESOURCE;

/**
 * @author Alexey Zhytnik
 * @since 31-Aug-16
 */
public class DocToPdfConverterTest extends FlowConverterTest {

    @Override
    protected String getResource() {
        return DOC_RESOURCE;
    }

    @Override
    protected FlowConverter<InputStream> getConverter() {
        return new DocToPdfConverter();
    }
}
