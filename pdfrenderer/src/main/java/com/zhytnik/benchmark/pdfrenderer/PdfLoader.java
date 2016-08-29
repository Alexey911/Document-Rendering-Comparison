package com.zhytnik.benchmark.pdfrenderer;

import com.sun.pdfview.PDFFile;
import com.zhytnik.benchmark.common.Loader;

import java.io.IOException;
import java.io.InputStream;

import static java.nio.ByteBuffer.wrap;
import static org.apache.commons.io.IOUtils.toByteArray;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
class PdfLoader implements Loader<InputStream, PDFFile> {
    @Override
    public PDFFile load(InputStream stream) throws IOException {
        byte[] data = toByteArray(stream);
        return new PDFFile(wrap(data));
    }
}
