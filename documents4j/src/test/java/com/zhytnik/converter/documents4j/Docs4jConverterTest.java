package com.zhytnik.converter.documents4j;

import com.zhytnik.converter.test.ConverterTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Runtime.getRuntime;
import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
abstract class Docs4jConverterTest extends ConverterTest {

    @BeforeEach
    void refreshTime() throws InterruptedException {
        sleep(1_000L);
    }

    @Test
    void worksWithMSOffice() throws Exception {
        int installed = getRuntime()
                .exec(new String[]{"cmd", "/c", "assoc", "." + getType().getExtension()})
                .getInputStream()
                .read();
        assertThat(installed).isPositive();
    }


}
