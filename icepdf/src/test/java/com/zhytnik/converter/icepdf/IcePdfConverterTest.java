package com.zhytnik.converter.icepdf;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.PDF;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class IcePdfConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return PDF;
    }

    @Override
    protected IcePdfConverter getConverter() {
        return new IcePdfConverter();
    }
}