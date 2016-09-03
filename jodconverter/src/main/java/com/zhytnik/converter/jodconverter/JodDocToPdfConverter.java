package com.zhytnik.converter.jodconverter;

import com.artofsolving.jodconverter.DocumentFormat;
import com.zhytnik.converter.common.Type;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class JodDocToPdfConverter extends JodConverter {

    @Override
    protected DocumentFormat getInputFormat() {
        return DOC;
    }

    @Override
    public boolean isSupported(Type type) {
        return type == Type.DOC;
    }

    @Override
    public String toString() {
        return "JodConverter doc to pdf converter (by LibreOffice)";
    }
}
