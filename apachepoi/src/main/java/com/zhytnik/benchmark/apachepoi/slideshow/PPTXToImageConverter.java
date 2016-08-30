package com.zhytnik.benchmark.apachepoi.slideshow;

import com.zhytnik.benchmark.common.Loader;
import com.zhytnik.benchmark.common.Renderer;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 29.08.2016
 */
public class PPTXToImageConverter extends SlideShowReader<XMLSlideShow> {

    @Override
    protected Renderer<XMLSlideShow> getRenderer() {
        return new PPTXRenderer();
    }

    @Override
    protected Loader<InputStream, XMLSlideShow> getLoader() {
        return new PPTXLoader();
    }
}
