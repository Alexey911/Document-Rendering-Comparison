package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.XLS;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeXlsConverter extends AsposeConverter {

    @Override
    protected String getExtension() {
        return XLS.getExtension();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == XLS;
    }

    @Override
    public String toString() {
        return "Aspose xls to image converter";
    }
}
