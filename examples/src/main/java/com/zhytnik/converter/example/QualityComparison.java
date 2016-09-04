package com.zhytnik.converter.example;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.zhytnik.converter.common.Converter;
import com.zhytnik.converter.common.Type;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;

import static com.zhytnik.converter.example.ConverterManager.getConverterName;
import static com.zhytnik.converter.example.FileManager.getFolderFiles;
import static com.zhytnik.converter.example.FileManager.loadFile;
import static com.zhytnik.converter.example.Logger.*;
import static org.apache.commons.io.FilenameUtils.removeExtension;

/**
 * @author Alexey Zhytnik
 * @since 04-Sep-16
 */
@SuppressWarnings("unchecked")
public class QualityComparison {

    @Parameter(names = "-resources", required = true,
            description = "Path to folder of resources with folders for every format")
    public File resources;

    @Parameter(names = "-output", required = true,
            description = "Path to output folder")
    public File output;

    public static void main(String[] args) throws Exception {
        QualityComparison comparison = new QualityComparison();
        new JCommander(comparison, args).usage();
        comparison.run();
        System.exit(0);
    }

    private void run() throws Exception {
        for (Converter converter : ConverterManager.getAll()) {
            for (Type type : Type.values()) {
                if (converter.isSupported(type)) {
                    for (File doc : loadDocumentsByType(type)) {
                        convertAndSave(converter, type, doc);
                    }
                }
            }
        }
    }

    private File[] loadDocumentsByType(Type type) {
        return getFolderFiles(resources + "/" + type.getExtension());
    }

    private void convertAndSave(Converter converter, Type type, File file) throws IOException {
        log(converter, CYAN);
        Object document = loadFile(file);
        try {
            Object converted = converter.convert(document);
            File output = getOutputFolder(converter, file, type);
            new Saver(output, true).save(converted);
        } catch (Exception e) {
            log(e.getMessage(), RED);
        }
        printDelimiter();
    }

    private File getOutputFolder(Converter converter, File file, Type type) {
        String output = MessageFormat.format("{0}/{1}/{2}/{3}", this.output, type.getExtension(),
                removeExtension(file.getName()), getConverterName(converter));
        return new File(output);
    }
}
