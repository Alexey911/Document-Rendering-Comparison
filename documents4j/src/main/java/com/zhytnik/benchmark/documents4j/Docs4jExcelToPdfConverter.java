package com.zhytnik.benchmark.documents4j;

import com.documents4j.api.DocumentType;

import static com.documents4j.api.DocumentType.XLS;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class Docs4jExcelToPdfConverter extends Docs4jConverter {
    @Override
    protected DocumentType getType() {
        return XLS;
    }
}
