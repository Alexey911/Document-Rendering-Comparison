package com.zhytnik.converter.kabeja;

import com.zhytnik.converter.common.Converter;
import com.zhytnik.converter.common.Type;
import org.kabeja.batik.tools.SAXPDFSerializer;
import org.kabeja.dxf.DXFDocument;
import org.kabeja.parser.ParseException;
import org.kabeja.parser.Parser;
import org.kabeja.parser.ParserBuilder;
import org.kabeja.svg.SVGGenerator;
import org.kabeja.xml.SAXSerializer;
import org.xml.sax.SAXException;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;

import static com.zhytnik.converter.common.Type.DXF;

/**
 * @author Alexey Zhytnik
 * @since 07-Sep-16
 */
public class KabejaDxfToPdfConverter implements Converter<InputStream, ByteArrayOutputStream> {

    @Override
    public ByteArrayOutputStream convert(InputStream resource) throws SAXException, ParseException {
        final DXFDocument document = load(resource);
        final ByteArrayOutputStream pdf = new ByteArrayOutputStream();
        convert(document, pdf);
        return pdf;
    }

    private DXFDocument load(InputStream resource) throws ParseException {
        final Parser parser = ParserBuilder.createDefaultParser();
        parser.parse(resource, "UTF-8");
        return parser.getDocument();
    }

    private void convert(DXFDocument document, ByteArrayOutputStream output) throws SAXException {
        final SAXSerializer serializer = new SAXPDFSerializer();
        serializer.setOutput(output);
        new SVGGenerator().generate(document, serializer, new HashMap<>());
    }

    @Override
    public boolean isSupported(Type type) {
        return type == DXF;
    }
}
