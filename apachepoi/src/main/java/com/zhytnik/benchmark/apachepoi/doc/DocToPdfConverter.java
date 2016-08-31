package com.zhytnik.benchmark.apachepoi.doc;

import com.zhytnik.benchmark.common.FlowConverter;
import org.docx4j.convert.in.Doc;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Alexey Zhytnik
 * @since 30-Aug-16
 */
public class DocToPdfConverter implements FlowConverter<InputStream> {

    private static final PrintStream DO_NOTHING_PRINT;

    static {
        DO_NOTHING_PRINT = new PrintStream(new OutputStream() {
            public void write(int c) {
            }
        });
    }

    @Override
    public ByteArrayOutputStream convert(InputStream resource) throws Exception {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        final PrintStream original = setOut(DO_NOTHING_PRINT);
        Doc.convert(resource).save(output);
        setOut(original);
        return output;
    }

    private PrintStream setOut(PrintStream out) {
        PrintStream original = System.out;
        System.setOut(out);
        return original;
    }
}
