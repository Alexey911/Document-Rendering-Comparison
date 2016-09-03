package com.zhytnik.benchmark.smartxls;

import com.zhytnik.benchmark.common.Type;
import com.zhytnik.benchmark.test.ConverterTest;

import static com.zhytnik.benchmark.common.Type.XLS;

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