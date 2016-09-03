package com.zhytnik.benchmark.jodconverter;

import com.zhytnik.benchmark.common.Type;
import com.zhytnik.benchmark.test.ConverterTest;

import static com.zhytnik.benchmark.common.Type.XLS;

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