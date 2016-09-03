package com.zhytnik.benchmark.apachepoi.doc;

import com.zhytnik.benchmark.common.Type;
import com.zhytnik.benchmark.test.ConverterTest;

import static com.zhytnik.benchmark.common.Type.DOC;

/**
 * @author Alexey Zhytnik
 * @since 31-Aug-16
 */
public class PoiDocToPdfConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return DOC;
    }

    @Override
    protected PoiDocToPdfConverter getConverter() {
        return new PoiDocToPdfConverter();
    }
}
