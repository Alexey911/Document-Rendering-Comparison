package com.zhytnik.benchmark.jodconverter;

import com.sun.star.io.XOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author Alexey Zhytnik
 * @since 01.09.2016
 */
final class JodOutputStream extends ByteArrayOutputStream implements XOutputStream {

    JodOutputStream() {
        super(32_768);
    }

    @Override
    public void writeBytes(byte[] bytes) {
        try {
            write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void closeOutput() {
        try {
            super.flush();
            super.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void flush() {
        try {
            super.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}