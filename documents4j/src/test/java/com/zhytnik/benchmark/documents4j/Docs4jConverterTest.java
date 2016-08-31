package com.zhytnik.benchmark.documents4j;

import com.zhytnik.benchmark.test.FlowConverterTest;
import org.junit.After;
import org.junit.Test;

import static java.lang.Runtime.getRuntime;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
abstract class Docs4jConverterTest extends FlowConverterTest {

    @Test
    public void worksWithMSOffice() throws Exception {
        int installed = getRuntime()
                .exec(new String[]{"cmd", "/c", "assoc", extension()})
                .getInputStream()
                .read();
        assertThat(installed).isPositive();
    }

    String extension() {
        String res = getResource();
        return res.substring(res.indexOf("."));
    }

    @After
    public void destroy() {
        ((Docs4jConverter) converter).shutdown();
    }
}
