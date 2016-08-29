package com.zhytnik.benchmark.pdfbox;

import com.zhytnik.benchmark.common.Renderer;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 25.08.2016
 */
// If you are using JDK8,
// set -Dsun.java2d.cmm=sun.java2d.cmm.kcms.KcmsServiceProvider
// or it will be very slow.
class PdfRenderer implements Renderer<PDDocument> {

    protected static final float DEFAULT_DPI = 300f;

    private float dpi = DEFAULT_DPI;

    @Override
    public List<Image> render(PDDocument data, int from, int to) throws IOException {
        final PDFRenderer renderer = new PDFRenderer(data);
        return render(renderer, from, to);
    }

    private List<Image> render(PDFRenderer renderer, int from, int to) throws IOException {
        final List<Image> images = new ArrayList<>(to - from);
        for (int index = from; index < to; index++) {
            images.add(renderer.renderImageWithDPI(index, dpi));
        }
        return images;
    }

    @Override
    public void setDpi(float dpi) {
        this.dpi = dpi;
    }
}
