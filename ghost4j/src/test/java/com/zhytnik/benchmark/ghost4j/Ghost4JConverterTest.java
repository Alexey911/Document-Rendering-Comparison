package com.zhytnik.benchmark.ghost4j;

import com.zhytnik.benchmark.common.Type;
import com.zhytnik.benchmark.test.ConverterTest;
import org.junit.jupiter.api.Test;

import static com.zhytnik.benchmark.common.Type.PDF;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public class Ghost4JConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return PDF;
    }

    @Override
    protected Ghost4JConverter getConverter() {
        return new Ghost4JConverter();
    }

    @Test
    void worksOnlyInWindows() {
        assertThat(System.getProperty("os.name")).containsIgnoringCase("windows");
    }
}
