package com.zhytnik.benchmark.common;

import java.io.ByteArrayOutputStream;

/**
 * @author Alexey Zhytnik
 * @since 31-Aug-16
 */
public interface FlowConverter<T> {
    ByteArrayOutputStream convert(T flow) throws Exception;
}
