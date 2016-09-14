package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.DXF;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeDxfConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return DXF;
    }

    @Override
    protected AsposeDxfConverter getConverter() {
        return new AsposeDxfConverter();
    }
}