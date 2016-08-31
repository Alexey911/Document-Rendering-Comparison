package com.zhytnik.benchmark.jodconverter;

import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.DocumentFormat;
import com.artofsolving.jodconverter.DocumentFormatRegistry;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.zhytnik.benchmark.common.FlowConverter;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.ConnectException;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
abstract class JodConverter implements FlowConverter<InputStream> {

    protected static final DocumentFormat DOC, PDF, PPT, XLS;

    static {
        DocumentFormatRegistry registry = new DefaultDocumentFormatRegistry();
        DOC = registry.getFormatByFileExtension("doc");
        PDF = registry.getFormatByFileExtension("pdf");
        PPT = registry.getFormatByFileExtension("ppt");
        XLS = registry.getFormatByFileExtension("xls");
    }

    @Override
    public ByteArrayOutputStream convert(InputStream resource) throws ConnectException {
        final OpenOfficeConnection connection = new SocketOpenOfficeConnection();
        try {
            connection.connect();
            return convert(connection, resource);
        } finally {
            connection.disconnect();
        }
    }

    private ByteArrayOutputStream convert(OpenOfficeConnection connection, InputStream resource) {
        DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        converter.convert(resource, getInputFormat(), output, PDF);
        return output;
    }

    protected abstract DocumentFormat getInputFormat();
}
