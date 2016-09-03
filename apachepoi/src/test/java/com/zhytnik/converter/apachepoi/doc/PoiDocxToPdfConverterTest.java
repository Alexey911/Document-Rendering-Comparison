package com.zhytnik.converter.apachepoi.doc;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.DOCX;

/**
 * @author Alexey Zhytnik
 * @since 31-Aug-16
 */
public class PoiDocxToPdfConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return DOCX;
    }

    @Override
    protected PoiDocxToPdfConverter getConverter() {
        return new PoiDocxToPdfConverter();
    }
}
