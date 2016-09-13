package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.PDF;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposePdfConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return PDF;
    }

    @Override
    protected AsposePdfConverter getConverter() {
        return new AsposePdfConverter();
    }
}