package com.zhytnik.benchmark.apachepoi.doc;

import com.zhytnik.benchmark.common.FlowConverter;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 29.08.2016
 */
public class DocxToPdfConverter implements FlowConverter<InputStream> {

    @Override
    public ByteArrayOutputStream convert(InputStream stream) throws Exception {
        try (XWPFDocument doc = new XWPFDocument(stream)) {
            return convert(doc);
        }
    }

    private ByteArrayOutputStream convert(XWPFDocument document) throws IOException {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        PdfConverter.getInstance().convert(document, output, PdfOptions.create());
        return output;
    }
}
