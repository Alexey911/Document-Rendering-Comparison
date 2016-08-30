package com.zhytnik.benchmark.apachepoi.doc;

import com.zhytnik.benchmark.common.FlowConverter;
import org.docx4j.convert.in.Doc;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 30-Aug-16
 */
public class DocToPdfConverter implements FlowConverter<InputStream> {
    @Override
    public ByteArrayOutputStream convert(InputStream resource) throws Exception {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        Doc.convert(resource).save(output);
        return output;
    }
}
