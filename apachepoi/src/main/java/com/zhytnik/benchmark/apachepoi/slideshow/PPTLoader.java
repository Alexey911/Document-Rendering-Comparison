package com.zhytnik.benchmark.apachepoi.slideshow;

import com.zhytnik.benchmark.common.Loader;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 29-Aug-16
 */
class PPTLoader implements Loader<InputStream, HSLFSlideShow> {
    @Override
    public HSLFSlideShow load(InputStream resource) throws IOException {
        return new HSLFSlideShow(resource);
    }
}
