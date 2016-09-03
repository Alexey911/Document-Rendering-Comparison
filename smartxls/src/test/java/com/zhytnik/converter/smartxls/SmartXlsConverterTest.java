package com.zhytnik.converter.smartxls;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.XLS;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
public class SmartXlsConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return XLS;
    }

    @Override
    protected SmartXlsConverter getConverter() {
        return new SmartXlsConverter();
    }
}