package com.zhytnik.converter.apachepoi.doc;

import com.zhytnik.converter.common.Converter;
import com.zhytnik.converter.common.PageObserver;
import com.zhytnik.converter.common.Type;
import org.apache.poi.hwpf.HWPFDocument;
import org.docx4j.convert.in.Doc;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static com.zhytnik.converter.common.Type.DOC;

/**
 * @author Alexey Zhytnik
 * @since 30-Aug-16
 */
public class PoiDocToPdfConverter implements
        Converter<InputStream, ByteArrayOutputStream>, PageObserver<InputStream> {

    private static final PrintStream DO_NOTHING_PRINT;

    static {
        DO_NOTHING_PRINT = new PrintStream(new OutputStream() {
            public void write(int c) {
            }
        });
    }

    @Override
    public ByteArrayOutputStream convert(InputStream document) throws Exception {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        final PrintStream original = setOut(DO_NOTHING_PRINT);
        try {
            Doc.convert(document).save(output);
        } finally {
            setOut(original);
        }
        return output;
    }

    private PrintStream setOut(PrintStream out) {
        PrintStream original = System.out;
        System.setOut(out);
        return original;
    }

    @Override
    public int getPageCount(InputStream stream) throws Exception {
        final HWPFDocument doc = new HWPFDocument(stream);
        return doc.getSummaryInformation().getPageCount();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == DOC;
    }

    @Override
    public String toString() {
        return "Docx4J wrapper of Apache POI doc to pdf converter";
    }
}
