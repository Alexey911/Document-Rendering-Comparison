package com.zhytnik.benchmark.apachepoi.slideshow;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;

import java.awt.*;

/**
 * @author Alexey Zhytnik
 * @since 29-Aug-16
 */
class PptxRenderer extends SlideShowRenderer<XMLSlideShow, XSLFSlide> {
    @Override
    protected Paint getSlideBackground(XSLFSlide slide) {
        return slide.getBackground().getFillColor();
    }
}
