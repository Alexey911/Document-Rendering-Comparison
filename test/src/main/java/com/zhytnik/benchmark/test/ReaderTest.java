package com.zhytnik.benchmark.test;

import com.zhytnik.benchmark.common.Reader;
import org.junit.Test;

import java.awt.*;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public abstract class ReaderTest {

    static final String PDF_RESOURCE = "test.pdf";

    static final int PAGE_COUNT = 3;
    static final int FROM = 0;
    static final int TO = 1;

    InputStream pdf = ResourceLoader.load(PDF_RESOURCE);
    Reader<InputStream> reader = getReader();

    @Test
    public void reads() throws Exception {
        assertThat(reader.read(pdf, FROM, TO)).isNotNull();
    }

    @Test
    public void readsWithoutLatest() throws Exception {
        assertThat(reader.read(pdf, FROM, TO)).hasSize(1);
    }

    @Test
    public void readsPageCount() throws Exception {
        assertThat(reader.pageCount(pdf)).isEqualTo(PAGE_COUNT);
    }

    @Test
    public void changesPageDpi() throws Exception {
        assertThat(getPageSizeByDpi(300f)).isGreaterThan(getPageSizeByDpi(200f));
    }

    int getPageSizeByDpi(float dpi) throws Exception {
        reader.setDpi(dpi);
        final Image image = reader.read(ResourceLoader.load(PDF_RESOURCE), 0, 1).get(0);
        return image.getHeight(null) * image.getWidth(null);
    }

    protected abstract Reader<InputStream> getReader();
}
