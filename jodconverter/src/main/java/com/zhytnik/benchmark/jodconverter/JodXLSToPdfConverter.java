package com.zhytnik.benchmark.jodconverter;

import com.artofsolving.jodconverter.DocumentFormat;

/**
 * @author Alexey Zhytnik
 * @since 31-Aug-16
 */
public class JodXLSToPdfConverter extends JodConverter {
    @Override
    protected DocumentFormat getInputFormat() {
        return XLS;
    }
}
