package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.TIFF;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeTifConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return TIFF;
    }

    @Override
    protected AsposeTifConverter getConverter() {
        return new AsposeTifConverter();
    }
}