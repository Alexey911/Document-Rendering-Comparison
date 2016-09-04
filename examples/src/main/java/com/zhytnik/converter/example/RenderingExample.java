package com.zhytnik.converter.example;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParametersDelegate;
import com.zhytnik.converter.common.Converter;

import java.io.File;
import java.io.InputStream;

import static com.zhytnik.converter.common.ConverterUtils.asSelective;
import static com.zhytnik.converter.common.ConverterUtils.isSelective;
import static com.zhytnik.converter.example.FileManager.loadFile;
import static com.zhytnik.converter.example.Logger.BLUE;
import static com.zhytnik.converter.example.Logger.RED;
import static com.zhytnik.converter.example.Logger.log;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
@SuppressWarnings("unchecked")
public class RenderingExample {

    @Parameter(names = "-converter", required = true,
            description = "Name of rendering framework")
    public String vendor;

    @Parameter(names = "-format", required = true,
            description = "Document format")
    public String format;

    @Parameter(names = "-source", required = true,
            description = "Path to document file")
    public File source;

    @Parameter(names = "-output", required = true,
            description = "Path to output folder")
    public File output;

    @Parameter(names = "-clear", description = "Clear output folder")
    public Boolean clear = true;

    public class RenderingInterval {
        @Parameter(names = "-begin", description = "First rendering page")
        public Integer begin;

        @Parameter(names = "-end", description = "Last rendering page")
        public Integer end;
    }

    @ParametersDelegate
    public RenderingInterval interval = new RenderingInterval();

    public static void main(String[] args) throws Exception {
        RenderingExample example = new RenderingExample();
        new JCommander(example, args).usage();
        displayFrameworks();
        example.run();
    }

    private static void displayFrameworks() {
        log("Enabled frameworks:", BLUE);
        log("- apachepoi    doc, docx, ppt, pptx", BLUE);
        log("- documents4j  doc, docx, xls, xlsx", BLUE);
        log("- SmartXLS     xls, xlsx", BLUE);
        log("- PDFBox       pdf", BLUE);
        log("- IcePDF       pdf", BLUE);
        log("- Ghost4J      pdf", BLUE);
        log("- PDFRenderer  pdf", BLUE);
    }

    public void run() throws Exception {
        final Converter converter = new ConverterManager(vendor, format).getByName();
        final InputStream document = loadFile(source);
        final Object converted = convert(converter, document);
        new Saver(output, clear).save(converted);
    }

    private Object convert(Converter converter, InputStream document) throws Exception {
        if (isSelectiveMode(converter)) {
            return asSelective(converter).convert(document, interval.begin, interval.end);
        }
        return converter.convert(document);
    }

    private boolean isSelectiveMode(Converter converter) {
        if (interval.begin == null || interval.end == null) return false;
        if (isSelective(converter)) return true;
        log("Warning: this framework not supported selective rendering", RED);
        return false;
    }
}
