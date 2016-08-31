package com.zhytnik.benchmark.test;

import com.google.common.collect.ImmutableMap;
import com.zhytnik.benchmark.common.Reader;
import org.junit.Test;

import java.awt.*;
import java.io.InputStream;
import java.util.Map;

import static com.zhytnik.benchmark.test.Resources.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public abstract class ReaderTest {

    static final Map<String, Integer> resourceSize = ImmutableMap.<String, Integer>builder()
            .put(PDF_RESOURCE, 4)
            .put(PPT_RESOURCE, 2)
            .put(PPTX_RESOURCE, 4)
            .put(DOC_RESOURCE, 3)
            .put(DOCX_RESOURCE, 2)
            .build();

    static final int FROM = 0;
    static final int TO = 1;

    Reader<InputStream> reader = getReader();

    @Test
    public void reads() throws Exception {
        assertThat(reader.read(data(), FROM, TO)).isNotNull();
    }

    @Test
    public void readsWithoutLatest() throws Exception {
        assertThat(reader.read(data(), FROM, TO)).hasSize(1);
    }

    @Test
    public void readsPageCount() throws Exception {
        assertThat(reader.pageCount(data()))
                .isEqualTo(resourceSize.get(getResource()));
    }

    @Test
    public void changesPageDpi() throws Exception {
        assertThat(getPageSizeByDpi(300f)).isGreaterThan(getPageSizeByDpi(200f));
    }

    int getPageSizeByDpi(float dpi) throws Exception {
        reader.setDpi(dpi);
        final Image image = reader.read(data(), 0, 1).get(0);
        return image.getHeight(null) * image.getWidth(null);
    }

    InputStream data() {
        return ResourceLoader.load(getResource());
    }

    protected abstract String getResource();

    protected abstract Reader<InputStream> getReader();
}
