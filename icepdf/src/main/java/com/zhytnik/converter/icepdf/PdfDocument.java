package com.zhytnik.converter.icepdf;

import org.icepdf.core.pobjects.Document;

import java.io.Closeable;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
final class PdfDocument extends Document implements Closeable {
    @Override
    public void close() {
        dispose();
    }
}
