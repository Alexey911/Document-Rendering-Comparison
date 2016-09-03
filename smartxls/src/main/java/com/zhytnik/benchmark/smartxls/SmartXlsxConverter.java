package com.zhytnik.benchmark.smartxls;

import com.zhytnik.benchmark.common.Type;

import java.io.InputStream;

import static com.zhytnik.benchmark.common.Type.XLSX;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
public class SmartXlsxConverter extends SmartConverter {

    @Override
    public boolean isSupported(Type type) {
        return type == XLSX;
    }

    @Override
    protected ExcelBook load(InputStream document) throws Exception {
        final ExcelBook book = new ExcelBook();
        book.readXLSX(document);
        return book;
    }

    @Override
    public String toString() {
        return "SmartXLS converter (xlsx version)";
    }
}
