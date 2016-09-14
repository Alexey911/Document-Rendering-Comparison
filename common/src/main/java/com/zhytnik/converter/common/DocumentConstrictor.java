package com.zhytnik.converter.common;

/**
 * @author Alexey Zhytnik
 * @since 09-Sep-16
 */
public interface DocumentConstrictor<T, R> {
    R constrict(T document, int begin, int end) throws Exception;
}
