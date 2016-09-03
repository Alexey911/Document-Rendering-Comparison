package com.zhytnik.benchmark.apachepoi.slideshow;

import com.zhytnik.benchmark.common.Type;
import com.zhytnik.benchmark.test.ConverterTest;

import static com.zhytnik.benchmark.common.Type.PPTX;

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
