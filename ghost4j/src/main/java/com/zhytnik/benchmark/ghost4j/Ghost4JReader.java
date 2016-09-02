package com.zhytnik.benchmark.ghost4j;

import com.zhytnik.benchmark.common.Reader;
import org.ghost4j.document.DocumentException;
import org.ghost4j.document.PDFDocument;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
//TODO: check Unix support
public class Ghost4JReader implements Reader<InputStream> {

    private PdfToImageRenderer pdfRenderer = new PdfToImageRenderer();

    @Override
    public List<Image> read(InputStream data, int from, int to) throws Exception {
        return pdfRenderer.render(load(data), from, to);
    }

    @Override
    public int pageCount(InputStream data) throws IOException, DocumentException {
        return load(data).getPageCount();
    }

    private PDFDocument load(InputStream data) throws IOException {
        final PDFDocument document = new PDFDocument();
        document.load(data);
        return document;
    }

    @Override
    public void setDpi(float dpi) {
        pdfRenderer.setDpi(dpi);
    }
}