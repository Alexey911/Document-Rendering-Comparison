package com.zhytnik.benchmark.icepdf;

import com.zhytnik.benchmark.common.Renderer;
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
class PdfToImageRenderer implements Renderer<Document> {

    private static final float DEFAULT_DPI = 300f;
    private static final float DEFAULT_ROTATION = 0f;

    private float dpi = DEFAULT_DPI;

    @Override
    public List<Image> render(Document document, int from, int to) {
        return range(from, to)
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
}
