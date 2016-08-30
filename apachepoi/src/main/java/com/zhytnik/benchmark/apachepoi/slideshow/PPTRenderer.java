package com.zhytnik.benchmark.apachepoi.slideshow;

import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;

import java.awt.*;

/**
 * @author Alexey Zhytnik
 * @since 29-Aug-16
 */
class PPTRenderer extends SlideShowRenderer<HSLFSlideShow, HSLFSlide> {
    @Override
    protected Paint getSlideBackground(HSLFSlide slide) {
        return slide.getBackground().getFill().getBackgroundColor();
    }
}
