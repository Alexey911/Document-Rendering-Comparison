package com.zhytnik.converter.test;

import com.google.common.collect.ImmutableMap;
import com.zhytnik.converter.common.Type;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static com.zhytnik.converter.common.Type.*;
import static org.apache.commons.io.IOUtils.toByteArray;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 31-Aug-16
 */
class Resources {

    private static final Map<Type, Integer> resourceSize = ImmutableMap.<Type, Integer>builder()
            .put(PDF, 4)
            .put(PPT, 2)
            .put(PPTX, 4)
            .put(DOC, 3)
            .put(DOCX, 2)
            .put(XLS, 3)
            .put(XLSX, 2)
            .put(TIFF, 10)
            .build();

    private Resources() {
    }

    static int getPageCount(Type type) {
        return resourceSize.get(type);
    }

    static InputStream loadByType(Type type) {
        try (InputStream resource = getResource("test." + type.getExtension())) {
            return new ByteArrayInputStream(toByteArray(resource));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static InputStream getResource(String name) {
        final InputStream stream = Resources.class.getClassLoader().getResourceAsStream(name);
        assertThat(stream).isNotNull();
        return stream;
    }
}
