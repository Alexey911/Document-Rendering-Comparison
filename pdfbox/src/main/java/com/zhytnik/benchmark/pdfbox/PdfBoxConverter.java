package com.zhytnik.benchmark.pdfbox;

import com.zhytnik.benchmark.common.PageObserver;
import com.zhytnik.benchmark.common.ResolutionConfigurable;
import com.zhytnik.benchmark.common.SelectiveConverter;
import com.zhytnik.benchmark.common.Type;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.awt.*;
import java.io.InputStream;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.zhytnik.benchmark.common.Type.PDF;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class PdfBoxConverter implements SelectiveConverter<InputStream, Image>,
        PageObserver<InputStream>, ResolutionConfigurable {

    private PdfRenderer renderer = new PdfRenderer();
    private PdfLoader pdfLoader = new PdfLoader();

    @Override
    public List<Image> convert(InputStream document) throws Exception {
        try (PDDocument pdf = pdfLoader.load(document)) {
            return renderer.render(pdf, 0, pdf.getNumberOfPages());
        }
    }

    @Override
    public List<Image> convert(InputStream document, int begin, int end) throws Exception {
        try (PDDocument pdf = pdfLoader.load(document)) {
            return renderer.render(pdf, begin, end);
        }
    }

    @Override
    public int getPageCount(InputStream document) throws Exception {
        try (PDDocument pdf = pdfLoader.load(document)) {
            return pdf.getNumberOfPages();
        }
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

    public void setLoadingBufferSize(long size) {
        pdfLoader.setBufferSize(size);
    }

    @Override
    public String toString() {
        return toStringHelper("PDFBox converter")
                .add("dpi", getDpi()).toString();
    }
}
