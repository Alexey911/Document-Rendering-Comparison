package com.zhytnik.benchmark.common;

import java.awt.*;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public interface Reader<T> {
    List<Image> read(T resource, int from, int to) throws Exception;

    int pageCount(T resource) throws Exception;

    void setDpi(float dpi);
}
