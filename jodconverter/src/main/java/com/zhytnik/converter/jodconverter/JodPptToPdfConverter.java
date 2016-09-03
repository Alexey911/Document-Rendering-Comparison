package com.zhytnik.converter.jodconverter;

import com.artofsolving.jodconverter.DocumentFormat;
import com.zhytnik.converter.common.Type;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class JodPptToPdfConverter extends JodConverter {

    @Override
    protected DocumentFormat getInputFormat() {
        return PPT;
    }

    @Override
    public boolean isSupported(Type type) {
        return type == Type.PPT;
    }

    @Override
    public String toString() {
        return "JodConverter ppt to pdf converter (by LibreOffice)";
    }
}
