package com.zhytnik.converter.groupdocs;


import com.aspose.email.MailMessage;
import com.groupdocs.conversion.converter.options.ImageSaveOptions;
import com.groupdocs.conversion.exception.ConversionException;
import com.groupdocs.conversion.handler.ConversionHandler;
import com.zhytnik.converter.common.Converter;
import com.zhytnik.converter.common.Type;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

import static com.aspose.email.SaveOptions.getDefaultMhtml;
import static com.zhytnik.converter.common.Type.MSG;

/**
 * @author Alexey Zhytnik
 * @since 14-Sep-16
 */
public class AsposeMsgConverter implements Converter<InputStream, List<ByteArrayOutputStream>> {

    private ConversionHandler handler = new ConversionHandler(new DefaultConfig());

    @Override
    public List<ByteArrayOutputStream> convert(InputStream document) throws Exception {
        ByteArrayInputStream mhtml = convertToMhtml(document);
        return AsposeUtil.convert(render(mhtml));
    }

    private ByteArrayInputStream convertToMhtml(InputStream resource) {
        final MailMessage message = MailMessage.load(resource);
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.save(out, getDefaultMhtml());
        return new ByteArrayInputStream(out.toByteArray());
    }

    private ImageSaveOptions getImageOptions() {
        final ImageSaveOptions options = new ImageSaveOptions();
        options.setSaveFileType(ImageSaveOptions.PNG);
        options.setResolution(options.getResolution() * 2);
        options.setAsListItems(true);
        return options;
    }

    private List<ByteArrayInputStream> render(ByteArrayInputStream resource) throws ConversionException {
        return handler.convertToImage(resource, ".Mhtml", getImageOptions());
    }

    @Override
    public boolean isSupported(Type type) {
        return type == MSG;
    }

    @Override
    public String toString() {
        return "Aspose msg to image converter";
    }
}