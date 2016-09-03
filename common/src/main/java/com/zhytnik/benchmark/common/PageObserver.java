package com.zhytnik.benchmark.common;

/**
 * @author Alexey Zhytnik
 * @since 02-Sep-16
 */
public interface PageObserver<T> {
    int getPageCount(T document) throws Exception;
}
