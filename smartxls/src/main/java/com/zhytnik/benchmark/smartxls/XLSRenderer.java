package com.zhytnik.benchmark.smartxls;

import com.smartxls.WorkBook;
import com.zhytnik.benchmark.common.Renderer;
import com.zhytnik.benchmark.common.SelectiveRenderer;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
class XLSRenderer implements Renderer<WorkBook>, SelectiveRenderer<WorkBook> {

    protected static final int MAX_ROWS = 35;
    protected static final int MAX_COLUMNS = 12;

    @Override
    public List<Image> render(WorkBook book) throws Exception {
        return render(book, 0, book.getNumSheets());
    }

    @Override
    public List<Image> render(WorkBook book, int begin, int end) throws Exception {
        final List<Image> images = new ArrayList<>(end - begin);
        book.setPrintGridLines(true);
        for (int i = begin; i < end; i++) {
            book.setSheet(i);
            images.add(book.sheetRangeToImage(0, 0, MAX_ROWS, MAX_COLUMNS));
        }
        return images;
    }
}
