package com.zhytnik.converter.pdfbox;

import com.zhytnik.converter.common.ResolutionConfigurable;
import com.zhytnik.converter.common.SelectiveRenderer;
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
/*In JDK 8 set -Dsun.java2d.cmm=sun.java2d.cmm.kcms.KcmsServiceProvider for faster rendering*/
class PdfRenderer implements SelectiveRenderer<PDDocument>, ResolutionConfigurable {

    protected static final float DEFAULT_DPI = 300f;

    private float dpi = DEFAULT_DPI;

    @Override
    public List<Image> render(PDDocument document, int begin, int end) throws IOException {
        final PDFRenderer renderer = new PDFRenderer(document);
        return render(renderer, begin, end);
    }

    private List<Image> render(PDFRenderer renderer, int begin, int end) throws IOException {
        final List<Image> images = new ArrayList<>(end - begin);
        for (int index = begin; index < end; index++) {
            images.add(renderer.renderImageWithDPI(index, dpi));
        }
        return images;
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
