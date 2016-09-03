package com.zhytnik.benchmark.jodconverter;

import com.zhytnik.benchmark.common.Type;

import static com.zhytnik.benchmark.common.Type.DOC;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class JodDocToPdfConverterTest extends JodConverterTest {

    @Override
    protected Type getType() {
        return DOC;
    }

    @Override
    protected JodDocToPdfConverter getConverter() {
        return new JodDocToPdfConverter();
    }
}
