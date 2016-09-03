package com.zhytnik.converter.apachepoi.slideshow;

import com.zhytnik.converter.common.Loader;
import com.zhytnik.converter.common.Type;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;

import java.io.InputStream;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.zhytnik.converter.common.Type.PPT;

/**
 * @author Alexey Zhytnik
 * @since 29.08.2016
 */
public class PoiPptConverter extends SlideShowConverter<HSLFSlideShow> {

    @Override
    protected Loader<InputStream, HSLFSlideShow> getLoader() {
        return new PptLoader();
    }

    @Override
    protected PptRenderer getRenderer() {
        return new PptRenderer();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == PPT;
    }

    @Override
    public String toString() {
        return toStringHelper("Apache POI ppt converter")
                .add("dpi", getDpi()).toString();
    }
}
