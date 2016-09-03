package com.zhytnik.converter.jodconverter;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.XLS;

/**
 * @author Alexey Zhytnik
 * @since 31-Aug-16
 */
public class JodXlsToPdfConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return XLS;
    }

    @Override
    protected JodXlsToPdfConverter getConverter() {
        return new JodXlsToPdfConverter();
    }
}