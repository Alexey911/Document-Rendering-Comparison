package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.DOCX;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeDocxConverter extends AsposeConverter {

    @Override
    protected String getExtension() {
        return DOCX.getExtension();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == DOCX;
    }

    @Override
    public String toString() {
        return "Aspose docx to image converter";
    }
}
