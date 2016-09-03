package com.zhytnik.benchmark.ghost4j;

import com.zhytnik.benchmark.common.Renderer;
import com.zhytnik.benchmark.common.ResolutionConfigurable;
import com.zhytnik.benchmark.common.SelectiveRenderer;
import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.SimpleRenderer;

import java.awt.*;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 25.08.2016
 */
class PdfRenderer implements Renderer<PDFDocument>,
        SelectiveRenderer<PDFDocument>, ResolutionConfigurable {

    protected static final int DEFAULT_DPI = 300;

    private SimpleRenderer renderer = new SimpleRenderer();

    public PdfRenderer() {
        setDpi(DEFAULT_DPI);
    }

    @Override
    public List<Image> render(PDFDocument document, int begin, int end) throws Exception {
        return renderer.render(document, begin, end - 1);
    }

    @Override
    public List<Image> render(PDFDocument document) throws Exception {
        return renderer.render(document);
    }

    @Override
    public void setDpi(float dpi) {
        renderer.setResolution((int) dpi);
    }

    @Override
    public float getDpi() {
        return renderer.getResolution();
    }
}
