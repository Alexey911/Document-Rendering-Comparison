package com.zhytnik.benchmark.common;

/**
 * @author Alexey Zhytnik
 * @since 02-Sep-16
 */
public interface Converter<T, R> {
    R convert(T document) throws Exception;

    boolean isSupported(Type type);
}
