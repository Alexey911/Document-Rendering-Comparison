package com.zhytnik.converter.jodconverter;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.DOC;

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
