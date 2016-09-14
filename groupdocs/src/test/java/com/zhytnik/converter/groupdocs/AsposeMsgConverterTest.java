package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.MSG;

/**
 * @author Alexey Zhytnik
 * @since 14-Sep-16
 */
public class AsposeMsgConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return MSG;
    }

    @Override
    protected AsposeMsgConverter getConverter() {
        return new AsposeMsgConverter();
    }
}