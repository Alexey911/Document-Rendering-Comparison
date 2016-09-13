package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.DOC;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeDocConverter extends AsposeConverter {

    @Override
    protected String getExtension() {
        return DOC.getExtension();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == DOC;
    }

    @Override
    public String toString() {
        return "Aspose doc to image converter";
    }
}
