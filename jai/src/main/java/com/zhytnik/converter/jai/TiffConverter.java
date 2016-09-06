package com.zhytnik.converter.jai;

import com.github.jaiimageio.impl.plugins.tiff.TIFFImageReaderSpi;
import com.github.jaiimageio.plugins.tiff.TIFFImageReadParam;
import com.zhytnik.converter.common.PageObserver;
import com.zhytnik.converter.common.SelectiveConverter;
import com.zhytnik.converter.common.Type;

import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.MemoryCacheImageInputStream;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.zhytnik.converter.common.Type.TIFF;

/**
 * @author Alexey Zhytnik
 * @since 06.09.2016
 */
public class TiffConverter implements SelectiveConverter<InputStream, Image>, PageObserver<InputStream> {

    private TIFFImageReaderSpi readerProvider = new TIFFImageReaderSpi();

    @Override
    public List<Image> convert(InputStream document, int begin, int end) throws Exception {
        final ImageReader reader = installReader();
        try (ImageInputStream image = getImage(document)) {
            reader.setInput(image, true, true);
            return read(reader, begin, end);
        } finally {
            reader.dispose();
        }
    }

    @Override
    public List<Image> convert(InputStream document) throws IOException {
        final ImageReader reader = installReader();
        try (ImageInputStream image = getImage(document)) {
            reader.setInput(image, false, true);
            return read(reader, 0, reader.getNumImages(true));
        } finally {
            reader.dispose();
        }
    }

    private List<Image> read(ImageReader reader, int begin, int end) throws IOException {
        final List<Image> images = new ArrayList<>(end - begin);
        for (int i = begin; i < end; i++) {
            images.add(reader.read(i, new TIFFImageReadParam()));
        }
        return images;
    }

    @Override
    public int getPageCount(InputStream document) throws IOException {
        final ImageReader reader = installReader();
        try (ImageInputStream image = getImage(document)) {
            reader.setInput(image, false, true);
            return reader.getNumImages(true);
        } finally {
            reader.dispose();
        }
    }

    private ImageReader installReader() {
        return readerProvider.createReaderInstance(null);
    }

    private ImageInputStream getImage(InputStream document) {
        return new MemoryCacheImageInputStream(document);
    }

    @Override
    public boolean isSupported(Type type) {
        return type == TIFF;
    }
}
