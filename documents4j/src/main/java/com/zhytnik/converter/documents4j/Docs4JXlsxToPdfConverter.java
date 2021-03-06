package com.zhytnik.converter.documents4j;

import com.documents4j.api.DocumentType;
import com.zhytnik.converter.common.Type;

import static com.documents4j.api.DocumentType.XLSX;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
public class Docs4JXlsxToPdfConverter extends Docs4jConverter {

    @Override
    protected DocumentType getType() {
        return XLSX;
    }

    @Override
    public boolean isSupported(Type type) {
        return type == Type.XLSX;
    }

    @Override
    public String toString() {
        return "documents4J xlsx to pdf converter";
    }
}
