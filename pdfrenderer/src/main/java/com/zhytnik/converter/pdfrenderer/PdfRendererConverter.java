package com.zhytnik.converter.pdfrenderer;

import com.sun.pdfview.PDFFile;
import com.zhytnik.converter.common.ResolutionConfigurable;
import com.zhytnik.converter.common.SelectiveConverter;
import com.zhytnik.converter.common.Type;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.zhytnik.converter.common.Type.PDF;
import static java.nio.ByteBuffer.wrap;
import static org.apache.commons.io.IOUtils.toByteArray;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class PdfRendererConverter implements
        SelectiveConverter<InputStream, Image>, ResolutionConfigurable {

    private PdfRenderer renderer = new PdfRenderer();

    @Override
    public List<Image> convert(InputStream document) throws Exception {
        return renderer.render(load(document));
    }

    @Override
    public List<Image> convert(InputStream document, int begin, int end) throws Exception {
        return renderer.render(load(document), begin, end);
    }

    @Override
    public int getPageCount(InputStream document) throws Exception {
        return load(document).getNumPages();
    }

    private PDFFile load(InputStream stream) throws IOException {
        final byte[] document = toByteArray(stream);
        return new PDFFile(wrap(document));
    }

    @Override
    public void setDpi(float dpi) {
        renderer.setDpi(dpi);
    }

    @Override
    public float getDpi() {
        return renderer.getDpi();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == PDF;
    }

    @Override
    public String toString() {
        return toStringHelper("PDFRenderer converter")
                .add("dpi", getDpi()).toString();
    }
}
