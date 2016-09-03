package com.zhytnik.converter.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.MessageFormat;
import java.util.List;

import static java.text.MessageFormat.format;
import static java.util.Arrays.stream;

/**
 * @author Alexey Zhytnik
 * @since 04-Sep-16
 */
@SuppressWarnings("unchecked")
class Saver {

    private final File folder;
    private Object data;
    private boolean clear;

    Saver(File folder, Object data, boolean clear) {
        this.folder = folder;
        this.data = data;
        this.clear = clear;
    }

    public void save() {
        if (clear) clearFolder(folder);
        if (data instanceof List) {
            writeImages(folder, (List<Image>) data);
        } else {
            write(folder, (ByteArrayOutputStream) data);
        }
    }

    private void clearFolder(File folder) {
        if (!folder.exists()) {
            create(folder);
            return;
        }
        System.out.println(MessageFormat.format("Clearing \"{0}\" folder", folder));
        File[] files = folder.listFiles();
        if (files != null) stream(files).forEach(File::delete);
    }

    private void create(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void write(File folder, ByteArrayOutputStream data) {
        System.out.println(MessageFormat.format("Started save file to \"{0}\" folder", folder));
        String file = MessageFormat.format("{0}{1}output.pdf", folder.getAbsoluteFile(), File.separator);
        try (OutputStream output = new BufferedOutputStream(new FileOutputStream(file))) {
            output.write(data.toByteArray());
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeImages(File folder, List<Image> images) {
        System.out.println(MessageFormat.format("Started save images to \"{0}\" folder", folder));
        try {
            for (int i = 0; i < images.size(); i++) {
                final Image image = images.get(i);
                final File file = generatePageFile(folder, i + 1);
                ImageIO.write((BufferedImage) image, "png", file);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
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
