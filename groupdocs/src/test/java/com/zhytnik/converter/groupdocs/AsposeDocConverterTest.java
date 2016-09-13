package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.DOC;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeDocConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return DOC;
    }

    @Override
    protected AsposeDocConverter getConverter() {
        return new AsposeDocConverter();
    }
}