package com.zhytnik.converter.common;

/**
 * @author Alexey Zhytnik
 * @since 02-Sep-16
 */
public enum Type {

    PDF("pdf"),
    DOC("doc"),
    DOCX("docx"),
    PPT("ppt"),
    PPTX("pptx"),
    XLS("xls"),
    XLSX("xlsx");

    private final String extension;

    Type(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }
}
