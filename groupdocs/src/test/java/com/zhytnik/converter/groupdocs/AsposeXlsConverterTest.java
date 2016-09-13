package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.XLS;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeXlsConverterTest extends ConverterTest {

    @Override
    protected AsposeXlsConverter getConverter() {
        return new AsposeXlsConverter();
    }

    @Override
    protected Type getType() {
        return XLS;
    }
}