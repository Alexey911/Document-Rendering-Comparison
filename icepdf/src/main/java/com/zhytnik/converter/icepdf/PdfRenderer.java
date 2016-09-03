package com.zhytnik.converter.icepdf;

import com.zhytnik.converter.common.Renderer;
import com.zhytnik.converter.common.ResolutionConfigurable;
import com.zhytnik.converter.common.SelectiveRenderer;
import org.icepdf.core.pobjects.Document;

import java.awt.*;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.icepdf.core.pobjects.Page.BOUNDARY_CROPBOX;
import static org.icepdf.core.util.GraphicsRenderingHints.PRINT;

/**
 * @author Alexey Zhytnik
 * @since 25.08.2016
 */
class PdfRenderer implements Renderer<Document>,
        SelectiveRenderer<Document>, ResolutionConfigurable {

    protected static final float DEFAULT_DPI = 300f;
    protected static final float DEFAULT_ROTATION = 0f;

    private float dpi = DEFAULT_DPI;

    @Override
    public List<Image> render(Document document) throws Exception {
        return render(document, 0, document.getNumberOfPages());
    }

    @Override
    public List<Image> render(Document document, int begin, int end) {
        return range(begin, end)
                .mapToObj(index -> document.getPageImage(
                        index,
                        PRINT /*without compression*/,
                        BOUNDARY_CROPBOX,
                        DEFAULT_ROTATION,
                        dpi / 72f
                ))
                .collect(toList());
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
