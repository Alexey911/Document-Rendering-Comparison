package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.DOCX;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeDocxConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return DOCX;
    }

    @Override
    protected AsposeDocxConverter getConverter() {
        return new AsposeDocxConverter();
    }
}