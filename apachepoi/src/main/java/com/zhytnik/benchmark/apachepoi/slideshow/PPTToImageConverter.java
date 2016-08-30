package com.zhytnik.benchmark.apachepoi.slideshow;

import com.zhytnik.benchmark.common.Loader;
import com.zhytnik.benchmark.common.Renderer;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;

import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 29.08.2016
 */
public class PPTToImageConverter extends SlideShowReader<HSLFSlideShow> {

    @Override
    protected Renderer<HSLFSlideShow> getRenderer() {
        return new PPTRenderer();
    }

    @Override
    protected Loader<InputStream, HSLFSlideShow> getLoader() {
        return new PPTLoader();
    }
}
