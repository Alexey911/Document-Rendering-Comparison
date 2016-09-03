package com.zhytnik.converter.pdfrenderer;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.PDF;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class PdfRendererReaderTest extends ConverterTest {

    @Override
    protected Type getType() {
        return PDF;
    }

    @Override
    protected PdfRendererConverter getConverter() {
        return new PdfRendererConverter();
    }
}
