package com.zhytnik.benchmark.icepdf;

import org.icepdf.core.pobjects.Document;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
final class PDFDocument extends Document implements AutoCloseable {
    @Override
    public void close() {
        dispose();
    }
}
