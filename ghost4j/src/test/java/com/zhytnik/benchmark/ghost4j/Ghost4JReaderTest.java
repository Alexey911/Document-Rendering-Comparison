package com.zhytnik.benchmark.ghost4j;

import com.zhytnik.benchmark.common.Reader;
import com.zhytnik.benchmark.test.ReaderTest;
import org.junit.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class Ghost4JReaderTest extends ReaderTest {

    @Override
    protected String getResource() {
        return PDF_RESOURCE;
    }

    @Override
    protected Reader<InputStream> getReader() {
        return new Ghost4JReader();
    }

    @Test
    public void worksOnlyInWindows() {
        assertThat(System.getProperty("os.name")).containsIgnoringCase("windows");
    }
}
