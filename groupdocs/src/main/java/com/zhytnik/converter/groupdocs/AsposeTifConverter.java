package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.TIFF;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeTifConverter extends AsposeConverter {

    @Override
    protected String getExtension() {
        return TIFF.getExtension();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == TIFF;
    }

    @Override
    public String toString() {
        return "Aspose tif to image converter";
    }
}
