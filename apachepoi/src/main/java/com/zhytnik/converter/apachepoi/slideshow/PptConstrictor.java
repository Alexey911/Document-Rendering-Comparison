package com.zhytnik.converter.apachepoi.slideshow;

import org.apache.poi.hslf.usermodel.HSLFSlideShow;

/**
 * @author Alexey Zhytnik
 * @since 09-Sep-16
 */
public class PptConstrictor extends SlideShowConstrictor<HSLFSlideShow> {

    @Override
    PptLoader getLoader() {
        return new PptLoader();
    }

    @Override
    void removeSlideShow(HSLFSlideShow s, int index) {
        s.removeSlide(index);
    }
}
