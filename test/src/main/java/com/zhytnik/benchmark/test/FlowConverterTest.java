package com.zhytnik.benchmark.test;

import com.zhytnik.benchmark.common.FlowConverter;
import org.junit.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 31-Aug-16
 */
public abstract class FlowConverterTest {

    protected FlowConverter<InputStream> converter = getConverter();

    @Test
    public void converts() throws Exception {
        assertThat(converter.convert(data())).isNotNull();
    }

    InputStream data() {
        return ResourceLoader.load(getResource());
    }

    protected abstract String getResource();

    protected abstract FlowConverter<InputStream> getConverter();
}
