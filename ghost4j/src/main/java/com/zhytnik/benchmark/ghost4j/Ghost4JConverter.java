package com.zhytnik.benchmark.ghost4j;

import com.zhytnik.benchmark.common.ResolutionConfigurable;
import com.zhytnik.benchmark.common.SelectiveConverter;
import com.zhytnik.benchmark.common.Type;
import org.ghost4j.document.DocumentException;
import org.ghost4j.document.PDFDocument;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.zhytnik.benchmark.common.Type.PDF;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
//TODO: check Unix support
public class Ghost4JConverter implements SelectiveConverter<InputStream, Image>, ResolutionConfigurable {

    private PdfRenderer renderer = new PdfRenderer();

    @Override
    public List<Image> convert(InputStream document) throws Exception {
        return renderer.render(load(document));
    }

    @Override
    public List<Image> convert(InputStream document, int begin, int end) throws Exception {
        return renderer.render(load(document), begin, end);
    }

    @Override
    public int getPageCount(InputStream document) throws IOException, DocumentException {
        return load(document).getPageCount();
    }

    private PDFDocument load(InputStream stream) throws IOException {
        final PDFDocument document = new PDFDocument();
        document.load(stream);
        return document;
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
        return toStringHelper("Ghost4j pdf converter")
                .add("dpi", getDpi()).toString();
    }
}