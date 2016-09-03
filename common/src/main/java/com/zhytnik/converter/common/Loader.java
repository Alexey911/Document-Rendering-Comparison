package com.zhytnik.converter.common;

/**
 * @author Alexey Zhytnik
 * @since 26.08.2016
 */
public interface Loader<T, R> {
    R load(T resource) throws Exception;
}
