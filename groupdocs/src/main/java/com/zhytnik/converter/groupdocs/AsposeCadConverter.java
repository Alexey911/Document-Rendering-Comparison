package com.zhytnik.converter.groupdocs;

import com.aspose.cad.Color;
import com.aspose.cad.Image;
import com.aspose.cad.imageoptions.CadRasterizationOptions;
import com.aspose.cad.imageoptions.PdfOptions;
import com.zhytnik.converter.common.Converter;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
abstract class AsposeCadConverter implements Converter<InputStream, ByteArrayOutputStream> {

    @Override
    public ByteArrayOutputStream convert(InputStream document) throws Exception {
        final Image image = Image.load(document);
        final PdfOptions options = getPdfOptions();
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        image.save(out, options);
        return out;
    }

    private PdfOptions getPdfOptions() {
        CadRasterizationOptions options = new CadRasterizationOptions();
        options.setBackgroundColor(Color.getWhite());
        options.setPageWidth(1600);
        options.setPageHeight(1600);

        PdfOptions renderOptions = new PdfOptions();
        renderOptions.setVectorRasterizationOptions(options);
        return renderOptions;
    }
}
