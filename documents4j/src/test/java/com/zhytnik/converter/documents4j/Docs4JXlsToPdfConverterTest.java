package com.zhytnik.converter.documents4j;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.XLS;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class Docs4JXlsToPdfConverterTest extends Docs4jConverterTest {

    @Override
    protected Type getType() {
        return XLS;
    }

    @Override
    protected Docs4jXlsToPdfConverter getConverter() {
        return new Docs4jXlsToPdfConverter();
    }
}