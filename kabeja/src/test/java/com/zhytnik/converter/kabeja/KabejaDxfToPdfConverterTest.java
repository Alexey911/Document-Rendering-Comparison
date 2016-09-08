package com.zhytnik.converter.kabeja;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.DXF;

/**
 * @author Alexey Zhytnik
 * @since 08-Sep-16
 */
public class KabejaDxfToPdfConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return DXF;
    }

    @Override
    protected KabejaDxfToPdfConverter getConverter() {
        return new KabejaDxfToPdfConverter();
    }
}