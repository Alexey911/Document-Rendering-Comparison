package com.zhytnik.benchmark.icepdf;

import com.zhytnik.benchmark.common.Reader;

import java.awt.*;
import java.io.InputStream;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class IcePdfReader implements Reader<InputStream> {

    private PdfToImageRenderer pdfRenderer = new PdfToImageRenderer();

    @Override
    public List<Image> read(InputStream resource, int from, int to) throws Exception {
        try (PDFDocument doc = load(resource)) {
            return pdfRenderer.render(doc, from, to);
        }
    }

    @Override
    public int pageCount(InputStream resource) throws Exception {
        try (PDFDocument doc = load(resource)) {
            return doc.getNumberOfPages();
        }
    }

    private PDFDocument load(InputStream resource) throws Exception {
        final PDFDocument pdf = new PDFDocument();
        pdf.setInputStream(resource, null /*document name*/);
        return pdf;
    }

    @Override
    public void setDpi(float dpi) {
        pdfRenderer.setDpi(dpi);
    }
}
