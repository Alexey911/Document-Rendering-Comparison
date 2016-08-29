package com.zhytnik.benchmark.pdfbox;

import com.zhytnik.benchmark.common.Reader;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.awt.*;
import java.io.InputStream;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class PdfBoxReader implements Reader<InputStream> {

    private PdfRenderer pdfRenderer = new PdfRenderer();
    private PdfLoader pdfLoader = new PdfLoader();

    @Override
    public List<Image> read(InputStream resource, int from, int to) throws Exception {
        try (PDDocument document = pdfLoader.load(resource)) {
            return pdfRenderer.render(document, from, to);
        }
    }

    @Override
    public int pageCount(InputStream resource) throws Exception {
        try (PDDocument data = pdfLoader.load(resource)) {
            return data.getNumberOfPages();
        }
    }

    @Override
    public void setDpi(float dpi) {
        pdfRenderer.setDpi(dpi);
    }

    public void setLoadingBufferSize(long size) {
        pdfLoader.setBufferSize(size);
    }
}
