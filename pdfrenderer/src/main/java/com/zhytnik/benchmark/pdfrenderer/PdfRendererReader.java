package com.zhytnik.benchmark.pdfrenderer;

import com.sun.pdfview.PDFFile;
import com.zhytnik.benchmark.common.Reader;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static java.nio.ByteBuffer.wrap;
import static org.apache.commons.io.IOUtils.toByteArray;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class PdfRendererReader implements Reader<InputStream> {

    private PdfToImageRenderer pdfRenderer = new PdfToImageRenderer();

    @Override
    public List<Image> read(InputStream data, int from, int to) throws Exception {
        return pdfRenderer.render(load(data), from, to);
    }

    @Override
    public int pageCount(InputStream data) throws Exception {
        return load(data).getNumPages();
    }

    private PDFFile load(InputStream data) throws IOException {
        byte[] resource = toByteArray(data);
        return new PDFFile(wrap(resource));
    }

    @Override
    public void setDpi(float dpi) {
        pdfRenderer.setDpi(dpi);
    }
}
