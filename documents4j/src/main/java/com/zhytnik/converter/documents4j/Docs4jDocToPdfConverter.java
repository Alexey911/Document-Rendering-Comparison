package com.zhytnik.converter.documents4j;

import com.documents4j.api.DocumentType;
import com.zhytnik.converter.common.Type;

import static com.documents4j.api.DocumentType.MS_WORD;
import static com.zhytnik.converter.common.Type.DOC;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class Docs4jDocToPdfConverter extends Docs4jConverter {

    @Override
    protected DocumentType getType() {
        return MS_WORD;
    }

    @Override
    public boolean isSupported(Type type) {
        return type == DOC;
    }

    @Override
    public String toString() {
        return "documents4J doc to pdf converter";
    }
}
