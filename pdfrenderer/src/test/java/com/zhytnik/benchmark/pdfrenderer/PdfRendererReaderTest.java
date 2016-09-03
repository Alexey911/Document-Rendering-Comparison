package com.zhytnik.benchmark.pdfrenderer;

import com.zhytnik.benchmark.common.Type;
import com.zhytnik.benchmark.test.ConverterTest;

import static com.zhytnik.benchmark.common.Type.PDF;

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
