package com.zhytnik.converter.example;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.MessageFormat;

import static com.zhytnik.converter.example.Logger.YELLOW;
import static com.zhytnik.converter.example.Logger.log;
import static org.apache.pdfbox.io.IOUtils.toByteArray;

/**
 * @author Alexey Zhytnik
 * @since 04-Sep-16
 */
class FileManager {

    static ByteArrayInputStream loadFile(File file) throws IOException {
        ByteArrayInputStream doc = new ByteArrayInputStream(toByteArray((new FileInputStream(file))));
        log(MessageFormat.format("Loaded \"{0}\"", file.getName()), YELLOW);
        return doc;
    }

    static File[] getFolderFiles(String folder) {
        File[] resources = new File(folder).listFiles();
        if (resources != null) return resources;
        return new File[]{};
    }
}
