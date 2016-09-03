package com.zhytnik.benchmark.common;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
public class ConverterUtils {

    private ConverterUtils() {
    }

    public static boolean isSelective(Converter converter) {
        return converter instanceof SelectiveConverter;
    }

    public static boolean isPageObserver(Converter converter) {
        return converter instanceof PageObserver;
    }

    public static boolean isResolutionConfigurable(Converter converter) {
        return converter instanceof ResolutionConfigurable;
    }

    @SuppressWarnings("unchecked")
    public static <T, R> SelectiveConverter<T, R> asSelective(Converter<T, R> converter) {
        return (SelectiveConverter<T, R>) converter;
    }

    @SuppressWarnings("unchecked")
    public static <T> PageObserver<T> asPageObserver(Converter<T, ?> converter) {
        return (PageObserver<T>) converter;
    }

    @SuppressWarnings("unchecked")
    public static ResolutionConfigurable asResolutionConfigurable(Converter converter) {
        return (ResolutionConfigurable) converter;
    }
}
