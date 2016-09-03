package com.zhytnik.benchmark.documents4j;

import com.zhytnik.benchmark.common.Type;

import static com.zhytnik.benchmark.common.Type.DOC;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class Docs4jDocToPdfConverterTest extends Docs4jConverterTest {

    @Override
    protected Type getType() {
        return DOC;
    }

    @Override
    protected Docs4jDocToPdfConverter getConverter() {
        return new Docs4jDocToPdfConverter();
    }
}
