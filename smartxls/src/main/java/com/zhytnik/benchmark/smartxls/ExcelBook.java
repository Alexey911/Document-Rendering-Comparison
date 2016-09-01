package com.zhytnik.benchmark.smartxls;

import com.smartxls.WorkBook;

import java.io.Closeable;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 02-Sep-16
 */
final class ExcelBook extends WorkBook implements Closeable {

    @Override
    public void close() {
        dispose();
    }

    static ExcelBook book(InputStream resource) throws Exception {
        final ExcelBook book = new ExcelBook();
        book.read(resource);
        return book;
    }
}
