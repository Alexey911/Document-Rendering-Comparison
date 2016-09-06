package com.zhytnik.converter.jai;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.TIFF;

/**
 * @author Alexey Zhytnik
 * @since 06.09.2016
 */
public class TiffConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return TIFF;
    }

    @Override
    protected TiffConverter getConverter() {
        return new TiffConverter();
    }
}
