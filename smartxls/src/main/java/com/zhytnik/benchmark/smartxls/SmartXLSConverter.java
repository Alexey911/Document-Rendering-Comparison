package com.zhytnik.benchmark.smartxls;

import com.zhytnik.benchmark.common.Reader;

import java.awt.*;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.zhytnik.benchmark.smartxls.ExcelBook.book;

/**
 * @author Alexey Zhytnik
 * @since 01.09.2016
 */
public class SmartXLSConverter implements Reader<InputStream> {

    private static final int MAX_ROWS = 35;
    private static final int MAX_COLUMNS = 12;

    @Override
    public List<Image> read(InputStream resource, int from, int to) throws Exception {
        final List<Image> images = new ArrayList<>(to - from);
        try (ExcelBook book = book(resource)) {
            book.setPrintGridLines(true);
            for (int i = from; i < to; i++) {
                book.setSheet(i);
                images.add(book.sheetRangeToImage(0, 0, MAX_ROWS, MAX_COLUMNS));
            }
            return images;
        }
    }

    @Override
    public int pageCount(InputStream resource) throws Exception {
        try (ExcelBook book = book(resource)) {
            return book.getNumSheets();
        }
    }

    @Override
    public void setDpi(float dpi) {
        throw new UnsupportedOperationException();
    }
}
