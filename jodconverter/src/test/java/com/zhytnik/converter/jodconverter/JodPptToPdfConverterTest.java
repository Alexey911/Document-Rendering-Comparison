package com.zhytnik.converter.jodconverter;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.PPT;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class JodPptToPdfConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return PPT;
    }

    @Override
    protected JodPptToPdfConverter getConverter() {
        return new JodPptToPdfConverter();
    }
}
