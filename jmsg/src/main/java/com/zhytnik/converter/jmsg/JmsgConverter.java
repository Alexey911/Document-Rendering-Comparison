package com.zhytnik.converter.jmsg;

import com.independentsoft.msg.Message;
import com.zhytnik.converter.common.Converter;
import com.zhytnik.converter.common.Type;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.zhytnik.converter.common.Type.MSG;

/**
 * @author Alexey Zhytnik
 * @since 15-Sep-16
 */
public class JmsgConverter implements Converter<InputStream, ByteArrayOutputStream> {

    @Override
    public ByteArrayOutputStream convert(InputStream document) throws IOException {
        Message message = new Message(document);
        throw new NotImplementedException();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == MSG;
    }

    @Override
    public String toString() {
        return "JMSG converter";
    }
}
