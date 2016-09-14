package com.zhytnik.converter.apachepoi.slideshow;

import com.zhytnik.converter.common.DocumentConstrictor;
import com.zhytnik.converter.common.Loader;
import org.apache.poi.sl.usermodel.SlideShow;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Alexey Zhytnik
 * @since 15-Sep-16
 */
abstract class SlideShowConstrictor<T extends SlideShow>
        implements DocumentConstrictor<InputStream, ByteArrayOutputStream> {

    private Loader<InputStream, T> loader = getLoader();

    abstract Loader<InputStream, T> getLoader();

    @Override
    public ByteArrayOutputStream constrict(InputStream document, int begin, int end) throws Exception {
        try (T s = loader.load(document)) {
            constrict(s, begin, end);
            return save(s);
        }
    }

    private void constrict(T s, int begin, int end) {
        int count = s.getSlides().size(), removed = 0;

        for (int i = 0; i < count; i++) {
            if (i < begin || i >= end) {
                removeSlideShow(s, i - removed);
                removed++;
            }
        }
    }

    abstract void removeSlideShow(T s, int index);

    private ByteArrayOutputStream save(T s) throws IOException {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        s.write(output);
        return output;
    }
}
