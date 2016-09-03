package com.zhytnik.benchmark.documents4j;

import com.zhytnik.benchmark.common.Type;

import static com.zhytnik.benchmark.common.Type.XLSX;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
public class Docs4JXlsxToPdfConverterTest extends Docs4jConverterTest {

    @Override
    protected Type getType() {
        return XLSX;
    }

    @Override
    protected Docs4XlsxToPdfConverter getConverter() {
        return new Docs4XlsxToPdfConverter();
    }
}
