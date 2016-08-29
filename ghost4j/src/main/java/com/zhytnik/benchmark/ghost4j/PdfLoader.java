package com.zhytnik.benchmark.ghost4j;

import com.zhytnik.benchmark.common.Loader;
import org.ghost4j.document.PDFDocument;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
class PdfLoader implements Loader<InputStream, PDFDocument> {
    @Override
    public PDFDocument load(InputStream data) throws IOException {
        final PDFDocument document = new PDFDocument();
        document.load(data);
        return document;
    }
}
