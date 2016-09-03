package com.zhytnik.converter.smartxls;

import com.smartxls.WorkBook;

import java.io.Closeable;

/**
 * @author Alexey Zhytnik
 * @since 02-Sep-16
 */
final class ExcelBook extends WorkBook implements Closeable {
    @Override
    public void close() {
        dispose();
    }
}
