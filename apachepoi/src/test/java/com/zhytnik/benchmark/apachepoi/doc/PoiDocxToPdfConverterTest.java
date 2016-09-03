package com.zhytnik.benchmark.apachepoi.doc;

import com.zhytnik.benchmark.common.Type;
import com.zhytnik.benchmark.test.ConverterTest;

import static com.zhytnik.benchmark.common.Type.DOCX;

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
