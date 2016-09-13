package com.zhytnik.converter.groupdocs;

import com.groupdocs.conversion.converter.options.ImageSaveOptions;
import com.groupdocs.conversion.handler.ConversionHandler;
import com.zhytnik.converter.common.Converter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
abstract class AsposeConverter implements Converter<InputStream, List<ByteArrayOutputStream>> {

    private ConversionHandler handler = new ConversionHandler(new DefaultConfig());

    @Override
    public List<ByteArrayOutputStream> convert(InputStream document) throws Exception {
        final ImageSaveOptions options = getImageConfig();
        List<ByteArrayInputStream> images = handler.convertToImage(document, "." + getExtension(), options);
        return AsposeUtil.convert(images);
    }

    private ImageSaveOptions getImageConfig() {
        final ImageSaveOptions options = new ImageSaveOptions();
        options.setSaveFileType(ImageSaveOptions.PNG);
        options.setResolution(options.getResolution() * 2);
        options.setAsListItems(true);
        return options;
    }

    protected abstract String getExtension();
}
