package com.zhytnik.converter.apachepoi.doc;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.DOC;

/**
 * @author Alexey Zhytnik
 * @since 31-Aug-16
 */
public class PoiDocToDocxConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return DOC;
    }

    @Override
    protected PoiDocToDocxConverter getConverter() {
        return new PoiDocToDocxConverter();
    }
}
