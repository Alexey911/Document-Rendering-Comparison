package com.zhytnik.converter.apachepoi.slideshow;

import org.apache.poi.xslf.usermodel.XMLSlideShow;

/**
 * @author Alexey Zhytnik
 * @since 09-Sep-16
 */
public class PptxConstrictor extends SlideShowConstrictor<XMLSlideShow> {

    @Override
    PptxLoader getLoader() {
        return new PptxLoader();
    }

    @Override
    void removeSlideShow(XMLSlideShow s, int pos) {
        s.removeSlide(pos);
    }
}
