package com.zhytnik.converter.common;

import java.awt.*;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 25.08.2016
 */
public interface Renderer<T> {
    List<Image> render(T document) throws Exception;
}
