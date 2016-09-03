package com.zhytnik.converter.documents4j;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.DOCX;

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
