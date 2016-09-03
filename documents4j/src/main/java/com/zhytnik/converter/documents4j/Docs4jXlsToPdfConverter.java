package com.zhytnik.converter.documents4j;

import com.documents4j.api.DocumentType;
import com.zhytnik.converter.common.Type;

import static com.documents4j.api.DocumentType.XLS;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class Docs4jXlsToPdfConverter extends Docs4jConverter {

    @Override
    protected DocumentType getType() {
        return XLS;
    }

    @Override
    public boolean isSupported(Type type) {
        return type == Type.XLS;
    }

    @Override
    public String toString() {
        return "documents4J xls to pdf converter";
    }
}
