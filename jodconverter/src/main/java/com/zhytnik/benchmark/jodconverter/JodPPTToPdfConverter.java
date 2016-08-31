package com.zhytnik.benchmark.jodconverter;

import com.artofsolving.jodconverter.DocumentFormat;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class JodPPTToPdfConverter extends JodConverter {
    @Override
    protected DocumentFormat getInputFormat() {
        return PPT;
    }
}
