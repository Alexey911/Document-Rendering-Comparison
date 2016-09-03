package com.zhytnik.benchmark.smartxls;

import com.zhytnik.benchmark.common.Type;
import com.zhytnik.benchmark.test.ConverterTest;

import static com.zhytnik.benchmark.common.Type.XLSX;

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
