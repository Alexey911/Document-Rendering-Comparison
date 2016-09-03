package com.zhytnik.benchmark.jodconverter;

import com.artofsolving.jodconverter.DocumentFormat;
import com.zhytnik.benchmark.common.Type;

/**
 * @author Alexey Zhytnik
 * @since 31-Aug-16
 */
public class JodXlsToPdfConverter extends JodConverter {

    @Override
    protected DocumentFormat getInputFormat() {
        return XLS;
    }

    @Override
    public boolean isSupported(Type type) {
        return type == Type.XLS;
    }

    @Override
    public String toString() {
        return "JodConverter xls to pdf converter (by LibreOffice)";
    }
}
