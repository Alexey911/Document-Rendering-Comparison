package com.zhytnik.converter.test;

import com.zhytnik.converter.common.Converter;
import com.zhytnik.converter.common.Type;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.InputStream;

import static com.zhytnik.converter.common.ConverterUtils.*;
import static com.zhytnik.converter.test.ConversionExtension.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(ConversionExtension.class)
public abstract class ConverterTest {

    int from = 0;
    int to = 1;

    Converter<InputStream, ?> converter = getConverter();
    InputStream document = Resources.loadByType(getType());

    @Test
    void converts() throws Exception {
        assertThat(converter.convert(document)).isNotNull();
    }

    @Test
    void knowsSupportedType() {
        assertThat(converter.isSupported(getType())).isTrue();
    }

    @Test
    @Disabled
    void failsWithUnknownFormats() {
        throw new NotImplementedException();
    }

    @Test
    @Disabled
    void safe() {
        throw new NotImplementedException();
    }

    @Test
    @Tag(SELECTIVE)
    void convertsInterval() throws Exception {
        assertThat(asSelective(converter).convert(document, from, to)).isNotNull();
    }

    @Test
    @Tag(SELECTIVE)
    public void convertsIntervalWithoutLatest() throws Exception {
        assertThat(asSelective(converter).convert(document, from, to)).hasSize(1);
    }

    @Test
    @Tag(PAGE_OBSERVER)
    void getsPageCount() throws Exception {
        int expected = Resources.getPageCount(getType());
        assertThat(asPageObserver(converter).getPageCount(document)).isEqualTo(expected);
    }

    @Test
    @Tag(RESOLUTION_CONFIGURABLE)
    void changesResolution() throws Exception {
        asResolutionConfigurable(converter).setDpi(200f);
    }

    protected abstract Converter<InputStream, ?> getConverter();

    protected abstract Type getType();
}
