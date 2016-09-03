package com.zhytnik.converter.example;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParametersDelegate;
import com.beust.jcommander.converters.FileConverter;
import com.zhytnik.converter.common.Converter;

import java.io.*;
import java.text.MessageFormat;

import static com.zhytnik.converter.common.ConverterUtils.asSelective;
import static com.zhytnik.converter.common.ConverterUtils.isSelective;
import static org.apache.pdfbox.io.IOUtils.toByteArray;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
@SuppressWarnings("unchecked")
public class RenderingExample {

    public class RenderingInterval {
        @Parameter(names = "-begin", description = "First rendering page")
        public Integer begin;

        @Parameter(names = "-end", description = "Last rendering page")
        public Integer end;
    }

    @Parameter(names = "-converter", required = true,
            description = "Name of rendering framework")
    public String vendor;

    @Parameter(names = "-format", required = true,
            description = "Document format")
    public String format;

    @Parameter(names = "-source", required = true,
            description = "Path to document file", converter = FileConverter.class)
    public File source;

    @Parameter(names = "-output", required = true,
            description = "Path to output folder", converter = FileConverter.class)
    public File output;

    @Parameter(names = "-clear", description = "Clear output folder")
    public Boolean clear = false;

    @ParametersDelegate
    public RenderingInterval interval = new RenderingInterval();

    public static void main(String[] args) throws Exception {
        displayFrameworks();
        RenderingExample example = new RenderingExample();
        new JCommander(example, args).usage();
        example.run();
    }

    private static void displayFrameworks() {
        System.out.println("Enabled frameworks:");
        System.out.println("- ApachePOI    doc, docx, ppt, pptx");
        System.out.println("- documents4J  doc, docx, xls, xlsx");
        System.out.println("- Ghost4J      pdf");
        System.out.println("- IcePDF       pdf");
        System.out.println("- PDFBox       pdf");
        System.out.println("- PDFRenderer  pdf");
        System.out.println("- SmartXLS     xls, xlsx");
    }

    public void run() throws Exception {
        final Converter converter = new ConverterManager(vendor, format).getConverterByName();
        final InputStream document = loadDocument(source);
        final Object rendered = convert(converter, document);
        new Saver(output, rendered, clear).save();
    }

    private Object convert(Converter converter, InputStream document) throws Exception {
        if (isSelectiveMode(converter)) {
            return asSelective(converter).convert(document, interval.begin, interval.end);
        }
        return converter.convert(document);
    }

    private static InputStream loadDocument(File file) throws IOException {
        ByteArrayInputStream doc = new ByteArrayInputStream(toByteArray((new FileInputStream(file))));
        System.out.println(MessageFormat.format("Document \"{0}\" loaded", file.getName()));
        return doc;
    }

    private boolean isSelectiveMode(Converter converter) {
        if (interval.begin == null || interval.end == null) return false;
        if (isSelective(converter)) return true;
        System.out.println("Framework not supported selective rendering");
        return false;
    }
}
