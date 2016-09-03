package com.zhytnik.benchmark.common;

import java.awt.*;
import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 02-Sep-16
 */
public interface SelectiveRenderer<T> {
    List<Image> render(T document, int begin, int end) throws Exception;
}
