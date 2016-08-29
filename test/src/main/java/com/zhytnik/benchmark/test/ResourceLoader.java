package com.zhytnik.benchmark.test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.apache.commons.io.IOUtils.toByteArray;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 25-Aug-16
 */
class ResourceLoader {
    static InputStream load(String resourceName) {
        try (InputStream resource = getResource(resourceName)) {
            return new ByteArrayInputStream(toByteArray(resource));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static InputStream getResource(String name) {
        final InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(name);
        assertThat(stream).isNotNull();
        return stream;
    }
}
