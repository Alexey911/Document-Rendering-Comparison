package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.DXF;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeDxfConverter extends AsposeCadConverter {

    @Override
    public boolean isSupported(Type type) {
        return type == DXF;
    }

    @Override
    public String toString() {
        return "Aspose CAD dxf converter";
    }
}
