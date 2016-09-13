package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.PPT;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposePptConverter extends AsposeConverter {

    @Override
    protected String getExtension() {
        return PPT.getExtension();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == PPT;
    }
}
