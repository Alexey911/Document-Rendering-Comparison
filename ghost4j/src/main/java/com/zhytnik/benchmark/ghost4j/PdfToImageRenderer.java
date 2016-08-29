package com.zhytnik.benchmark.ghost4j;

import com.zhytnik.benchmark.common.Renderer;
import org.ghost4j.document.PDFDocument;
import org.ghost4j.renderer.SimpleRenderer;

import java.awt.*;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 25.08.2016
 */
class PdfToImageRenderer implements Renderer<PDFDocument> {

    private static final int DEFAULT_DPI = 300;

    private int dpi = DEFAULT_DPI;

    @Override
    public List<Image> render(PDFDocument data, int from, int to) throws Exception {
        final SimpleRenderer renderer = new SimpleRenderer();
        renderer.setResolution(dpi);
        return renderer.render(data, from, to - 1);
    }

    @Override
    public void setDpi(float dpi) {
        this.dpi = (int) dpi;
    }
}
