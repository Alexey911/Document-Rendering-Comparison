package com.zhytnik.converter.groupdocs;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
class AsposeUtil {

    private AsposeUtil() {
    }

    public static List<ByteArrayOutputStream> convert(List<ByteArrayInputStream> items) throws IOException {
        final List<ByteArrayOutputStream> converted = new ArrayList<>(items.size());
        for (InputStream image : items) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            IOUtils.copy(image, output);
            converted.add(output);
        }
        return converted;
    }
}
