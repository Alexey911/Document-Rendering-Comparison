package com.zhytnik.converter.pdfbox;

import com.zhytnik.converter.common.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.pdfbox.io.MemoryUsageSetting.setupMainMemoryOnly;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
class PdfLoader implements Loader<InputStream, PDDocument> {

    protected static final long DEFAULT_BUFFER_SIZE = 36L * 1024L * 1024L;

    private long bufferSize = DEFAULT_BUFFER_SIZE;

    @Override
    public PDDocument load(InputStream document) throws IOException {
        return PDDocument.load(document, setupMainMemoryOnly(bufferSize));
    }

    void setBufferSize(long bufferSize) {
        if (bufferSize < 20L * 1024L * 1024L) {
            throw new IllegalArgumentException("Buffer size must be at least 20 MB!");
        }
        this.bufferSize = bufferSize;
    }
}
