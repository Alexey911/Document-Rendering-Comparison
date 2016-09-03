package com.zhytnik.benchmark.smartxls;

import com.zhytnik.benchmark.common.Type;

import java.io.InputStream;

import static com.zhytnik.benchmark.common.Type.XLS;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
public class SmartXlsConverter extends SmartConverter {

    @Override
    public boolean isSupported(Type type) {
        return type == XLS;
    }

    @Override
    protected ExcelBook load(InputStream document) throws Exception {
        final ExcelBook book = new ExcelBook();
        book.read(document);
        return book;
    }

    @Override
    public String toString() {
        return "SmartXLS converter (xls version)";
    }
}
