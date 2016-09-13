package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.PDF;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposePdfConverter extends AsposeConverter {

    @Override
    protected String getExtension() {
        return PDF.getExtension();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == PDF;
    }

    @Override
    public String toString() {
        return "Aspose pdf to image converter";
    }
}
