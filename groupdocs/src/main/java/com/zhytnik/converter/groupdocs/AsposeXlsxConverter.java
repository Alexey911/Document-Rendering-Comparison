package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.XLSX;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeXlsxConverter extends AsposeConverter {

    @Override
    protected String getExtension() {
        return XLSX.getExtension();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == XLSX;
    }

    @Override
    public String toString() {
        return "Aspose xlsx to image converter";
    }
}
