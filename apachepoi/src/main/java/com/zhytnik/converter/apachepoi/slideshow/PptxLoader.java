package com.zhytnik.converter.apachepoi.slideshow;

import com.zhytnik.converter.common.Loader;
import org.apache.poi.xslf.usermodel.XMLSlideShow;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 29-Aug-16
 */
class PptxLoader implements Loader<InputStream, XMLSlideShow> {
    @Override
    public XMLSlideShow load(InputStream document) throws IOException {
        return new XMLSlideShow(document);
    }
}
