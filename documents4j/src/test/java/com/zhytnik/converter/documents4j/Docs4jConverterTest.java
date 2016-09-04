package com.zhytnik.converter.documents4j;

import com.zhytnik.converter.test.ConverterTest;
import org.junit.jupiter.api.Test;

import static java.lang.Runtime.getRuntime;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
abstract class Docs4jConverterTest extends ConverterTest {
    @Test
    void worksWithMSOffice() throws Exception {
        int installed = getRuntime()
                .exec(new String[]{"cmd", "/c", "assoc", "." + getType().getExtension()})
                .getInputStream()
                .read();
        assertThat(installed).isPositive();
    }
}
