package com.zhytnik.benchmark.apachepoi.slideshow;

import com.zhytnik.benchmark.common.Loader;
import com.zhytnik.benchmark.common.Reader;
import com.zhytnik.benchmark.common.Renderer;
import org.apache.poi.sl.usermodel.SlideShow;

import java.awt.*;
import java.io.InputStream;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 29-Aug-16
 */
abstract class SlideShowReader<T extends SlideShow> implements Reader<InputStream> {

    private Loader<InputStream, T> loader = getLoader();

    private Renderer<T> renderer = getRenderer();

    @Override
    public List<Image> read(InputStream stream, int from, int to) throws Exception {
        try (T s = loader.load(stream)) {
            return renderer.render(s, from, to);
        }
    }

    @Override
    public int pageCount(InputStream stream) throws Exception {
        try (T s = loader.load(stream)) {
            return s.getSlides().size();
        }
    }

    @Override
    public void setDpi(float dpi) {
        renderer.setDpi(dpi);
    }

    protected abstract Renderer<T> getRenderer();

    protected abstract Loader<InputStream, T> getLoader();
}
