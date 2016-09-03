package com.zhytnik.benchmark.jodconverter;

import com.zhytnik.benchmark.common.Type;
import com.zhytnik.benchmark.test.ConverterTest;

import static com.zhytnik.benchmark.common.Type.PPT;

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
