package com.zhytnik.converter.jwordconverter;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.DOC;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class JWordConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return DOC;
    }

    @Override
    protected JWordConverter getConverter() {
        return new JWordConverter();
    }
}