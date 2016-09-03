package com.zhytnik.converter.pdfbox;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.PDF;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class PdfBoxConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return PDF;
    }

    @Override
    protected PdfBoxConverter getConverter() {
        return new PdfBoxConverter();
    }
}
