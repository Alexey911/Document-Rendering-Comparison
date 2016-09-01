package com.zhytnik.benchmark.jodconverter;

import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentFormat;
import com.artofsolving.jodconverter.DocumentFormatRegistry;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.google.common.collect.ImmutableMap;
import com.sun.star.beans.PropertyValue;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.frame.XStorable;
import com.sun.star.io.XOutputStream;
import com.sun.star.lang.XComponent;
import com.sun.star.uno.UnoRuntime;
import com.zhytnik.benchmark.common.FlowConverter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static com.zhytnik.benchmark.jodconverter.JodUtils.*;
import static org.apache.commons.io.IOUtils.toByteArray;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
abstract class JodConverter implements FlowConverter<InputStream> {

    private static final Map<String, Object> DEFAULT_LOAD_PROPERTIES;

    protected static final DocumentFormat DOC, PDF, PPT, XLS;

    static {
        DEFAULT_LOAD_PROPERTIES = ImmutableMap.of("Hidden", Boolean.TRUE, "ReadOnly", Boolean.TRUE);

        DocumentFormatRegistry registry = new DefaultDocumentFormatRegistry();
        DOC = registry.getFormatByFileExtension("doc");
        PDF = registry.getFormatByFileExtension("pdf");
        PPT = registry.getFormatByFileExtension("ppt");
        XLS = registry.getFormatByFileExtension("xls");
    }

    @Override
    public ByteArrayOutputStream convert(InputStream resource) throws Exception {
        final OpenOfficeConnection connection = new SocketOpenOfficeConnection();
        try {
            connection.connect();
            final XComponent doc = load(connection, resource, getInputFormat());
            refresh(doc);
            return convert(doc, getInputFormat(), PDF);
        } finally {
            connection.disconnect();
        }
    }

    public XComponent load(OpenOfficeConnection connection, InputStream input,
                           DocumentFormat format) throws Exception {
        XComponentLoader desktop = connection.getDesktop();
        PropertyValue[] settings = configure(input, format);
        return desktop.loadComponentFromURL("private:stream", "_blank", 0, settings);
    }

    @SuppressWarnings("unchecked")
    private PropertyValue[] configure(InputStream resource, DocumentFormat format) throws IOException {
        final Map<String, Object> config = new HashMap<>(DEFAULT_LOAD_PROPERTIES);
        config.putAll(format.getImportOptions());
        config.put("InputStream", new JodInputStream(toByteArray(resource)));
        return properties(config);
    }

    private ByteArrayOutputStream convert(XComponent document, DocumentFormat inputFormat,
                                          DocumentFormat outputFormat) throws Exception {
        final JodOutputStream out = new JodOutputStream();
        try {
            XStorable storable = (XStorable) UnoRuntime.queryInterface(XStorable.class, document);
            PropertyValue[] settings = configure(out, outputFormat, inputFormat);
            storable.storeToURL("private:stream", settings);
            return out;
        } finally {
            quietlyClose(document);
        }
    }

    @SuppressWarnings("unchecked")
    private PropertyValue[] configure(XOutputStream stream, DocumentFormat out, DocumentFormat in) {
        final Map<String, Object> config = new HashMap<>(out.getExportOptions(in.getFamily()));
        config.put("OutputStream", stream);
        return properties(config);
    }

    protected abstract DocumentFormat getInputFormat();
}
