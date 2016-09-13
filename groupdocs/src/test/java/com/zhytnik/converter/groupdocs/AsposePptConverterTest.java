package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.PPT;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposePptConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return PPT;
    }

    @Override
    protected AsposePptConverter getConverter() {
        return new AsposePptConverter();
    }
}