package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.PPTX;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposePptxConverter extends AsposeConverter {

    @Override
    protected String getExtension() {
        return PPTX.getExtension();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == PPTX;
    }

    @Override
    public String toString() {
        return "Aspose pptx to image converter";
    }
}
