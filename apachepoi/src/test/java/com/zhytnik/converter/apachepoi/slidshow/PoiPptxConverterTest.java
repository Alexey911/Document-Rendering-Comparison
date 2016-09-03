package com.zhytnik.converter.apachepoi.slidshow;

import com.zhytnik.converter.apachepoi.slideshow.PoiPptxConverter;
import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.PPTX;

/**
 * @author Alexey Zhytnik
 * @since 30-Aug-16
 */
public class PoiPptxConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return PPTX;
    }

    @Override
    protected PoiPptxConverter getConverter() {
        return new PoiPptxConverter();
    }
}
