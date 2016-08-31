package com.zhytnik.benchmark.jodconverter;

import com.artofsolving.jodconverter.DocumentFormat;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class JodDocToPdfConverter extends JodConverter {
    @Override
    protected DocumentFormat getInputFormat() {
        return DOC;
    }
}
