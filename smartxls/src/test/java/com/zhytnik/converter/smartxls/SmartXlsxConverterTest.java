package com.zhytnik.converter.smartxls;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.XLSX;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
public class SmartXlsxConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return XLSX;
    }

    @Override
    protected SmartXlsxConverter getConverter() {
        return new SmartXlsxConverter();
    }
}
