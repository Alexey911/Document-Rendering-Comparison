package com.zhytnik.benchmark.common;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class ConversationException extends RuntimeException {

    public ConversationException() {
    }

    public ConversationException(Exception e) {
        super(e);
    }
}
