package com.zhytnik.benchmark.apachepoi.slideshow;

import com.zhytnik.benchmark.common.Loader;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 29-Aug-16
 */
class PPTXLoader implements Loader<InputStream, XMLSlideShow> {
    @Override
    public XMLSlideShow load(InputStream resource) throws IOException {
        return new XMLSlideShow(resource);
    }
}
