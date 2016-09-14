package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.DWG;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeDwgConverter extends AsposeCadConverter {

    @Override
    public boolean isSupported(Type type) {
        return type == DWG;
    }

    @Override
    public String toString() {
        return "Aspose CAD dwg converter";
    }
}
