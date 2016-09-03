package com.zhytnik.benchmark.apachepoi.slideshow;

import com.zhytnik.benchmark.common.Loader;
import com.zhytnik.benchmark.common.ResolutionConfigurable;
import com.zhytnik.benchmark.common.SelectiveConverter;
import org.apache.poi.sl.usermodel.SlideShow;

import java.awt.*;
import java.io.InputStream;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 29-Aug-16
 */
abstract class SlideShowConverter<T extends SlideShow>
        implements SelectiveConverter<InputStream, Image>, ResolutionConfigurable {

    private Loader<InputStream, T> loader = getLoader();

    private SlideShowRenderer<T, ?> renderer = getRenderer();

    protected abstract Loader<InputStream, T> getLoader();

    protected abstract SlideShowRenderer<T, ?> getRenderer();

    @Override
    public List<Image> convert(InputStream document) throws Exception {
        try (T slideshow = loader.load(document)) {
            return renderer.render(slideshow);
        }
    }

    @Override
    public List<Image> convert(InputStream document, int begin, int end) throws Exception {
        try (T slideshow = loader.load(document)) {
            return renderer.render(slideshow, begin, end);
        }
    }

    @Override
    public int getPageCount(InputStream document) throws Exception {
        try (T slideshow = loader.load(document)) {
            return slideshow.getSlides().size();
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
}
