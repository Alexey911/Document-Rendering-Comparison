package com.zhytnik.converter.common;

import java.util.List;

/**
 * @author Alexey Zhytnik
 * @since 02-Sep-16
 */
public interface SelectiveConverter<T, R> extends Converter<T, List<R>>, PageObserver<T> {
    List<R> convert(T document, int begin, int end) throws Exception;
}
