package com.zhytnik.benchmark.icepdf;

import com.zhytnik.benchmark.common.Loader;
import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
class PdfLoader implements Loader<InputStream, PDFDocument> {
    @Override
    public PDFDocument load(InputStream stream) throws IOException, PDFException, PDFSecurityException {
        final PDFDocument pdf = new PDFDocument();
        pdf.setInputStream(stream, null /*document name*/);
        return pdf;
    }
}
