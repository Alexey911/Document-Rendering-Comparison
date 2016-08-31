package com.zhytnik.benchmark.documents4j;

import com.documents4j.api.DocumentType;

import static com.documents4j.api.DocumentType.MS_WORD;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class Docs4jDocToPdfConverter extends Docs4jConverter {
    @Override
    protected DocumentType getType() {
        return MS_WORD;
    }
}
