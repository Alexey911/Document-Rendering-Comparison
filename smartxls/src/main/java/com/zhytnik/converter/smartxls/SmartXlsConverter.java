package com.zhytnik.converter.smartxls;

import com.zhytnik.converter.common.Type;

import java.io.InputStream;

import static com.zhytnik.converter.common.Type.XLS;

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
