package com.zhytnik.converter.apachepoi.slidshow;

import com.zhytnik.converter.apachepoi.slideshow.PoiPptConverter;
import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.PPT;

/**
 * @author Alexey Zhytnik
 * @since 30-Aug-16
 */
public class PoiPptConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return PPT;
    }

    @Override
    protected PoiPptConverter getConverter() {
        return new PoiPptConverter();
    }
}
