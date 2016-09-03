package com.zhytnik.benchmark.test;

import com.zhytnik.benchmark.common.Converter;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.TestExecutionCondition;
import org.junit.jupiter.api.extension.TestExtensionContext;

import java.lang.reflect.Method;

import static com.zhytnik.benchmark.common.ConverterUtils.*;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.disabled;
import static org.junit.jupiter.api.extension.ConditionEvaluationResult.enabled;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
class ConversionExtension implements TestExecutionCondition, BeforeEachCallback {

    static final String SELECTIVE = "1";
    static final String PAGE_OBSERVER = "2";
    static final String RESOLUTION_CONFIGURABLE = "3";

    @Override
    public ConditionEvaluationResult evaluate(TestExtensionContext context) {
        final Method method = context.getTestMethod().get();
        if (!isSpecial(method)) return enabled("not checkable");

        final String capacity = method.getAnnotation(Tag.class).value();
        boolean hasCapacity = checkCapacity(getTest(context).converter, capacity);
        return condition(hasCapacity);
    }

    private boolean isSpecial(Method method) {
        return method != null && method.isAnnotationPresent(Tag.class);
    }

    private boolean checkCapacity(Converter converter, String capacity) {
        switch (capacity) {
            case SELECTIVE:
                return isSelective(converter);
            case PAGE_OBSERVER:
                return isPageObserver(converter);
            case RESOLUTION_CONFIGURABLE:
                return isResolutionConfigurable(converter);
        }
        throw new IllegalArgumentException("There's no such capacity!");
    }

    private ConditionEvaluationResult condition(boolean allow) {
        return allow ? enabled("ok") : disabled("there's no capacity!");
    }

    @Override
    public void beforeEach(TestExtensionContext context) throws Exception {
        final ConverterTest test = getTest(context);
        if (test.document.markSupported()) test.document.reset();
    }

    private ConverterTest getTest(TestExtensionContext context) {
        return (ConverterTest) context.getTestInstance();
    }
}
