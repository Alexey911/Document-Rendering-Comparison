package com.zhytnik.benchmark.smartxls;

import com.zhytnik.benchmark.common.SelectiveConverter;

import java.awt.*;
import java.io.InputStream;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 01.09.2016
 */
abstract class SmartConverter implements SelectiveConverter<InputStream, Image> {

    private XLSRenderer renderer = new XLSRenderer();

    @Override
    public List<Image> convert(InputStream document) throws Exception {
        try (ExcelBook book = load(document)) {
            return renderer.render(book);
        }
    }

    @Override
    public List<Image> convert(InputStream document, int begin, int end) throws Exception {
        try (ExcelBook book = load(document)) {
            return renderer.render(book, begin, end);
        }
    }

    @Override
    public int getPageCount(InputStream document) throws Exception {
        try (ExcelBook book = load(document)) {
            return book.getNumSheets();
        }
    }

    protected abstract ExcelBook load(InputStream document) throws Exception;

    @Override
    public String toString() {
        return "SmartXLS converter (supported formats: XLS, XLSX)";
    }
}
