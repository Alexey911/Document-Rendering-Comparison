package com.zhytnik.benchmark.smartxls;

import com.smartxls.WorkBook;
import com.zhytnik.benchmark.common.FlowConverter;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 01.09.2016
 */
public class SmartXLSConverter implements FlowConverter<InputStream> {
    @Override
    public ByteArrayOutputStream convert(InputStream flow) throws Exception {
        final WorkBook book = new WorkBook();
        book.read(flow);
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        book.exportPDF(output, null, false);
        return output;
    }
}
