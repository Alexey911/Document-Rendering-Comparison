package com.zhytnik.converter.apachepoi.slideshow;

import com.zhytnik.converter.common.Loader;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 29-Aug-16
 */
class PptLoader implements Loader<InputStream, HSLFSlideShow> {
    @Override
    public HSLFSlideShow load(InputStream document) throws IOException {
        return new HSLFSlideShow(document);
    }
}
