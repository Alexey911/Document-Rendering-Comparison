package com.zhytnik.converter.jwordconverter;

import com.qoppa.word.WordDocument;
import com.qoppa.word.WordException;
import com.zhytnik.converter.common.Converter;
import com.zhytnik.converter.common.Type;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static com.zhytnik.converter.common.Type.DOC;
import static com.zhytnik.converter.common.Type.DOCX;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class JWordConverter implements Converter<InputStream, List<ByteArrayOutputStream>> {

    @Override
    public List<ByteArrayOutputStream> convert(InputStream resource) throws Exception {
        final WordDocument document = new WordDocument(resource);
        int count = document.getPageCount();
        List<ByteArrayOutputStream> pages = newArrayList();
        for (int i = 0; i < count; i++) pages.add(render(document, i));
        return pages;
    }

    private ByteArrayOutputStream render(WordDocument document, int page) throws IOException, WordException {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        document.savePageAsPNG(page, out, 300);
        return out;
    }

    @Override
    public boolean isSupported(Type type) {
        return type == DOC || type == DOCX;
    }

    @Override
    public String toString() {
        return "JWord doc(docx) to images converter";
    }
}
