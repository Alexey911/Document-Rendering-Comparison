package com.zhytnik.benchmark.pdfrenderer;

import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import com.zhytnik.benchmark.common.Renderer;
import com.zhytnik.benchmark.common.ResolutionConfigurable;
import com.zhytnik.benchmark.common.SelectiveRenderer;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/**
 * @author Alexey Zhytnik
 * @since 25.08.2016
 */
class PdfRenderer implements Renderer<PDFFile>,
        SelectiveRenderer<PDFFile>, ResolutionConfigurable {

    private static final boolean BLOCKING_READING = true;
    private static final float DEFAULT_DPI = 300f;

    private float dpi = DEFAULT_DPI;

    @Override
    public List<Image> render(PDFFile document) throws Exception {
        return render(document, 0, document.getNumPages());
    }

    @Override
    public List<Image> render(PDFFile document, int begin, int end) throws Exception {
        return range(begin, end)
                .mapToObj(index -> document.getPage(index, BLOCKING_READING))
                .map(this::load)
                .collect(toList());
    }

    private Image load(PDFPage page) {
        Rectangle2D frame = page.getBBox();
        int w = (int) frame.getWidth();
        int h = (int) frame.getHeight();
        Rectangle body = new Rectangle(0, 0, w, h);
        return page.getImage(scale(w), scale(h), body, null, true, BLOCKING_READING);
    }

    private int scale(int value) {
        return (int) ((value * dpi) / 72f);
    }

    @Override
    public void setDpi(float dpi) {
        this.dpi = dpi;
    }

    @Override
    public float getDpi() {
        return dpi;
    }
}
