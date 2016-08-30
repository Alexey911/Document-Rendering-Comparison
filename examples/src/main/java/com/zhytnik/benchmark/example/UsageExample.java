package com.zhytnik.benchmark.example;

import com.zhytnik.benchmark.apachepoi.slideshow.PPTToImageConverter;
import com.zhytnik.benchmark.apachepoi.slideshow.PPTXToImageConverter;
import com.zhytnik.benchmark.common.Reader;
import com.zhytnik.benchmark.ghost4j.Ghost4JReader;
import com.zhytnik.benchmark.icepdf.IcePdfReader;
import com.zhytnik.benchmark.pdfbox.PdfBoxReader;
import com.zhytnik.benchmark.pdfrenderer.PdfRendererReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

import static java.io.File.separator;
import static java.lang.System.currentTimeMillis;
import static java.text.MessageFormat.format;
import static org.apache.pdfbox.io.IOUtils.toByteArray;

/**
 * @author Alexey Zhytnik
 * @since 26-Aug-16
 */
public class UsageExample {
    public static void main(String[] args) throws Exception {
        checkArguments(args);
        String vendor = args[0];
        String pathToPdf = args[1];
        String outFolder = args[2];
        int startPage = Integer.valueOf(args[3]);
        int endPage = Integer.valueOf(args[4]);
        writeImages(readPages(vendor, pathToPdf, startPage, endPage), outFolder);
    }

    private static void checkArguments(String[] args) {
        if (args.length != 5) {
            throw new IllegalArgumentException("Must be 5 arguments(vendor [supported: Ghost4J, ICEpdf, PDFBox, " +
                    "PDFrenderer, POI-ppt, POI-pptx], path to pdf, output folder, start and end pages), " +
                    "there's " + args.length + " args");
        }
    }

    private static List<Image> readPages(String vendor, String pathToPdf,
                                         int startPage, int endPage) throws Exception {
        final Reader<InputStream> reader = choiceReader(vendor);
        final InputStream pdf = readFile(pathToPdf);
        int mem = getMemoryUsage();
        long t = currentTimeMillis();
        List<Image> images = reader.read(pdf, startPage, endPage);
        t = currentTimeMillis() - t;
        mem = getMemoryUsage() - mem;
        printSpeed(t, endPage - startPage);
        printMemory(mem);
        return images;
    }

    private static int getMemoryUsage() {
        Runtime runtime = Runtime.getRuntime();
        int one_mb = 1024 * 1024;
        return (int) (runtime.totalMemory() - runtime.freeMemory()) / one_mb;
    }

    private static void printMemory(int used) {
        System.out.println(format("used ~{0} mb", used));
    }

    private static void printSpeed(long t, int count) {
        float speed = ((float) t) / count;
        System.out.println(format("{0} page(-s) converted at {1} ms, {2} img/ms", count, t, speed));
    }

    private static Reader<InputStream> choiceReader(String vendor) {
        Reader<InputStream> reader;
        String s = vendor.toLowerCase();
        switch (s) {
            case "ghost4j":
                System.out.println("Using Ghost4J reader!");
                reader = new Ghost4JReader();
                break;
            case "icepdf":
                System.out.println("Using ICEpdf reader!");
                reader = new IcePdfReader();
                break;
            case "pdfbox":
                System.out.println(
                        "Using PDFBox reader!\n" +
                                "If you are using JDK8, set " +
                                "-Dsun.java2d.cmm=sun.java2d.cmm.kcms.KcmsServiceProvider or it will be very slow!!!");
                reader = new PdfBoxReader();
                break;
            case "pdfrenderer":
                System.out.println("Using PDFrenderer reader!");
                reader = new PdfRendererReader();
                break;
            case "poi-ppt":
                System.out.println("Using Apache POI PPT-reader!");
                reader = new PPTToImageConverter();
                break;
            case "poi-pptx":
                System.out.println("Using Apache POI PPTX-reader!");
                reader = new PPTXToImageConverter();
                break;
            default:
                System.out.println(format("There's no \"{0}\" reader, " +
                        "used default Ghost4J reader!", vendor));
                reader = new Ghost4JReader();
        }
        return reader;
    }

    private static InputStream readFile(String file) throws IOException {
        return new ByteArrayInputStream(toByteArray((new FileInputStream(file))));
    }

    private static void writeImages(List<Image> images,
                                    String folder) throws IOException {
        for (int i = 0; i < images.size(); i++) {
            final Image image = images.get(i);
            final File file = generatePageFile(folder, i + 1);
            ImageIO.write((BufferedImage) image, "png", file);
        }
    }

    private static File generatePageFile(String folder, int index) throws IOException {
        String name = format("{0}{1}page_{2}.png", folder, separator, index);
        final File file = new File(name);
        if (!file.createNewFile())
            throw new IllegalArgumentException(format("There is images with name \"{0}\"", name));
        return file;
    }
}
