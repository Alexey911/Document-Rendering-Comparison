package com.zhytnik.converter.example;

import com.sun.star.uno.RuntimeException;
import com.zhytnik.converter.apachepoi.doc.PoiDocToPdfConverter;
import com.zhytnik.converter.apachepoi.doc.PoiDocxToPdfConverter;
import com.zhytnik.converter.apachepoi.slideshow.PoiPptConverter;
import com.zhytnik.converter.apachepoi.slideshow.PoiPptxConverter;
import com.zhytnik.converter.common.Converter;
import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.documents4j.Docs4XlsxToPdfConverter;
import com.zhytnik.converter.documents4j.Docs4jDocToPdfConverter;
import com.zhytnik.converter.documents4j.Docs4jDocxToPdfConverter;
import com.zhytnik.converter.documents4j.Docs4jXlsToPdfConverter;
import com.zhytnik.converter.ghost4j.Ghost4JConverter;
import com.zhytnik.converter.icepdf.IcePdfConverter;
import com.zhytnik.converter.jodconverter.JodDocToPdfConverter;
import com.zhytnik.converter.jodconverter.JodPptToPdfConverter;
import com.zhytnik.converter.jodconverter.JodXlsToPdfConverter;
import com.zhytnik.converter.pdfbox.PdfBoxConverter;
import com.zhytnik.converter.pdfrenderer.PdfRendererConverter;
import com.zhytnik.converter.smartxls.SmartXlsConverter;
import com.zhytnik.converter.smartxls.SmartXlsxConverter;

import java.text.MessageFormat;

import static com.zhytnik.converter.common.Type.*;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
class ConverterManager {

    private final String framework;
    private final String format;

    ConverterManager(String framework, String format) {
        this.framework = framework.toLowerCase();
        this.format = format;
    }

    public Converter getConverterByName() {
        Converter c = getByName();
        System.out.println(MessageFormat.format("Selected \"{0}\"", c));
        return c;
    }

    private Converter getByName() {
        switch (framework) {
            case "icepdf"      : return getIcePdfConverter();
            case "pdfbox"      : return getPdfBoxConverter();
            case "ghost4j"     : return getGhost4JConverter();
            case "smartxls"    : return getSmartXLSConverter();
            case "apachepoi"   : return getApachePOIConverter();
            case "documents4j" : return getDocuments4j();
            case "pdfrenderer" : return getPdfRendererConverter();
            case "jodconverter": return getJodConverter();
        }
        return failOnUnknownFramework();
    }

    private Converter failOnUnknownFramework() {
        throw new RuntimeException(MessageFormat.format("Unknown \"{0}\" framework", framework));
    }

    private Converter getGhost4JConverter() {
        return new Ghost4JConverter();
    }

    private Converter getIcePdfConverter() {
        return new IcePdfConverter();
    }

    private Converter getPdfBoxConverter() {
        System.out.println("In \"JDK 8\" set " +
                "-Dsun.java2d.cmm=sun.java2d.cmm.kcms.KcmsServiceProvider " +
                "for faster rendering*");
        return new PdfBoxConverter();
    }

    private Converter getPdfRendererConverter() {
        return new PdfRendererConverter();
    }

    private Converter getApachePOIConverter() {
        if (isFormat(PPT))  return new PoiPptConverter();
        if (isFormat(PPTX)) return new PoiPptxConverter();
        if (isFormat(DOC))  return new PoiDocToPdfConverter();
        if (isFormat(DOCX)) return new PoiDocxToPdfConverter();
        return failOnUnknownFormat();
    }

    private Converter getSmartXLSConverter() {
        if (isFormat(XLS))  return new SmartXlsConverter();
        if (isFormat(XLSX)) return new SmartXlsxConverter();
        return failOnUnknownFormat();
    }

    private Converter getJodConverter() {
        if (isFormat(DOC)) return new JodDocToPdfConverter();
        if (isFormat(PPT)) return new JodPptToPdfConverter();
        if (isFormat(XLS)) return new JodXlsToPdfConverter();
        return failOnUnknownFormat();
    }

    private Converter getDocuments4j() {
        if (isFormat(DOC))  return new Docs4jDocToPdfConverter();
        if (isFormat(DOCX)) return new Docs4jDocxToPdfConverter();
        if (isFormat(XLS))  return new Docs4jXlsToPdfConverter();
        if (isFormat(XLSX)) return new Docs4XlsxToPdfConverter();
        return failOnUnknownFormat();
    }

    private boolean isFormat(Type type) {
        return format.equals(type.getExtension());
    }

    private Converter failOnUnknownFormat() {
        throw new IllegalArgumentException(MessageFormat.format("The framework don''t support \"{0}\" format", format));
    }
}