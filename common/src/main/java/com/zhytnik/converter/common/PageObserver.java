package com.zhytnik.converter.common;

/**
 * @author Alexey Zhytnik
 * @since 02-Sep-16
 */
public interface PageObserver<T> {
    int getPageCount(T document) throws Exception;
}
