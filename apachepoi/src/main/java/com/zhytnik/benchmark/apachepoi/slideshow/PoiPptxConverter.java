package com.zhytnik.benchmark.apachepoi.slideshow;

import com.zhytnik.benchmark.common.Loader;
import com.zhytnik.benchmark.common.Type;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.InputStream;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.zhytnik.benchmark.common.Type.PPTX;

/**
 * @author Alexey Zhytnik
 * @since 29.08.2016
 */
public class PoiPptxConverter extends SlideShowConverter<XMLSlideShow> {

    @Override
    protected Loader<InputStream, XMLSlideShow> getLoader() {
        return new PptxLoader();
    }

    @Override
    protected PptxRenderer getRenderer() {
        return new PptxRenderer();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == PPTX;
    }

    @Override
    public String toString() {
        return toStringHelper("Apache POI pptx converter")
                .add("dpi", getDpi()).toString();
    }
}
