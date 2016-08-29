package com.zhytnik.benchmark.common;

import java.awt.*;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 25.08.2016
 */
public interface Renderer<T> {
    List<Image> render(T data, int from, int to) throws Exception;

    void setDpi(float dpi);
}
