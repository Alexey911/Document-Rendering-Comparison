package com.zhytnik.benchmark.jodconverter;

import com.sun.star.io.XInputStream;
import com.sun.star.io.XSeekable;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author Alexey Zhytnik
 * @since 01.09.2016
 */
final class JodInputStream extends ByteArrayInputStream implements XInputStream, XSeekable {

    JodInputStream(byte[] buffer) {
        super(buffer);
    }

    @Override
    public int readBytes(byte[][] bytes, int needed) {
        int count;
        byte[] buffer = new byte[needed];
        try {
            count = super.read(buffer);
            if (hasData(count)) {
                if (needed > count) {
                    byte[] temp = new byte[count];
                    System.arraycopy(buffer, 0, temp, 0, count);
                    buffer = temp;
                }
            } else {
                buffer = new byte[0];
                count = 0;
            }
            bytes[0] = buffer;
            return count;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean hasData(int count) {
        return count > 0;
    }

    @Override
    public int readSomeBytes(byte[][] bytes, int i) {
        return readBytes(bytes, i);
    }

    @Override
    public void skipBytes(int i) {
        skip(i);
    }

    @Override
    public void closeInput() {
        try {
            close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void seek(long l) {
        this.pos = (int) l;
    }

    @Override
    public long getPosition() {
        return pos;
    }

    @Override
    public long getLength() {
        return count;
    }
}