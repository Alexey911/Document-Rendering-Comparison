package com.zhytnik.benchmark.documents4j;

import com.zhytnik.benchmark.common.Type;

import static com.zhytnik.benchmark.common.Type.DOCX;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class Docs4jDocxToPdfConverterTest extends Docs4jConverterTest {

    @Override
    protected Type getType() {
        return DOCX;
    }

    @Override
    protected Docs4jDocxToPdfConverter getConverter() {
        return new Docs4jDocxToPdfConverter();
    }
}
