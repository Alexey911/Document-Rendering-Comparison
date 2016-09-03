package com.zhytnik.benchmark.documents4j;

import com.zhytnik.benchmark.common.Type;

import static com.zhytnik.benchmark.common.Type.XLS;

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