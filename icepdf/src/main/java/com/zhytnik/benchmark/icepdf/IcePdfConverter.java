package com.zhytnik.benchmark.icepdf;

import com.zhytnik.benchmark.common.ResolutionConfigurable;
import com.zhytnik.benchmark.common.SelectiveConverter;
import com.zhytnik.benchmark.common.Type;

import java.awt.*;
import java.io.InputStream;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.zhytnik.benchmark.common.Type.PDF;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class IcePdfConverter implements SelectiveConverter<InputStream, Image>, ResolutionConfigurable {

    private PdfRenderer renderer = new PdfRenderer();

    @Override
    public List<Image> convert(InputStream document) throws Exception {
        try (PdfDocument doc = load(document)) {
            return renderer.render(doc);
        }
    }

    @Override
    public List<Image> convert(InputStream document, int begin, int end) throws Exception {
        try (PdfDocument doc = load(document)) {
            return renderer.render(doc, begin, end);
        }
    }

    @Override
    public int getPageCount(InputStream document) throws Exception {
        try (PdfDocument doc = load(document)) {
            return doc.getNumberOfPages();
        }
    }

    private PdfDocument load(InputStream document) throws Exception {
        final PdfDocument pdf = new PdfDocument();
        pdf.setInputStream(document, null /*document name*/);
        return pdf;
    }

    @Override
    public void setDpi(float dpi) {
        renderer.setDpi(dpi);
    }

    @Override
    public float getDpi() {
        return renderer.getDpi();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == PDF;
    }

    @Override
    public String toString() {
        return toStringHelper("IcePdf converter")
                .add("dpi", getDpi()).toString();
    }
}
