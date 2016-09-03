package com.zhytnik.converter.documents4j;

import com.documents4j.api.DocumentType;
import com.zhytnik.converter.common.Type;

import static com.documents4j.api.DocumentType.DOCX;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class Docs4jDocxToPdfConverter extends Docs4jConverter {

    @Override
    protected DocumentType getType() {
        return DOCX;
    }

    @Override
    public boolean isSupported(Type type) {
        return type == Type.DOCX;
    }

    @Override
    public String toString() {
        return "documents4J docx to pdf converter";
    }
}
