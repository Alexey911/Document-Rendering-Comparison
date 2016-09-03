package com.zhytnik.benchmark.apachepoi.slideshow;

import com.zhytnik.benchmark.common.Type;
import com.zhytnik.benchmark.test.ConverterTest;

import static com.zhytnik.benchmark.common.Type.PPT;

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
