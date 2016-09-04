package com.zhytnik.converter.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.MessageFormat;
import java.util.List;

import static com.zhytnik.converter.example.Logger.YELLOW;
import static com.zhytnik.converter.example.Logger.log;
import static java.text.MessageFormat.format;
import static java.util.Arrays.stream;

/**
 * @author Alexey Zhytnik
 * @since 04-Sep-16
 */
@SuppressWarnings("unchecked")
class Saver {

    private final File folder;
    private final boolean clear;

    Saver(File folder, boolean clear) {
        this.folder = folder;
        this.clear = clear;
    }

    public void save(Object data) throws IOException {
        createIfNotExist(folder);
        if (clear) clearFolder(folder);
        if (data instanceof List) {
            writeImages(folder, (List<Image>) data);
        } else {
            write(folder, (ByteArrayOutputStream) data);
        }
    }

    private boolean createIfNotExist(File file) throws IOException {
        return !file.exists() && file.mkdirs();
    }

    private void clearFolder(File folder) throws IOException {
        log(MessageFormat.format("Clearing \"{0}\"", folder), YELLOW);
        File[] files = folder.listFiles();
        if (files != null) stream(files).forEach(File::delete);
    }

    private void write(File folder, ByteArrayOutputStream data) throws IOException {
        log(MessageFormat.format("Save pdf to \"{0}\"", folder), YELLOW);
        String file = MessageFormat.format("{0}/output.pdf", folder.getAbsoluteFile());
        try (OutputStream output = new BufferedOutputStream(new FileOutputStream(file))) {
            output.write(data.toByteArray());
            output.close();
        }
    }

    private void writeImages(File folder, List<Image> images) throws IOException {
        log(MessageFormat.format("Save images to \"{0}\"", folder), YELLOW);
        for (int i = 0; i < images.size(); i++) {
            final Image image = images.get(i);
            final File file = generatePageFile(folder, i + 1);
            ImageIO.write((BufferedImage) image, "png", file);
        }
    }

    private File generatePageFile(File folder, int index) throws IOException {
        String name = format("{0}{1}page_{2}.png", folder, File.separator, index);
        final File file = new File(name);
        if (!file.createNewFile())
            throw new IllegalArgumentException(format("There is images with name \"{0}\"", name));
        return file;
    }
}
