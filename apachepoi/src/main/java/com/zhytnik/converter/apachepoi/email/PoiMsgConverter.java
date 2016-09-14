package com.zhytnik.converter.apachepoi.email;

import com.zhytnik.converter.common.Converter;
import com.zhytnik.converter.common.Type;
import org.apache.poi.hsmf.MAPIMessage;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import static com.zhytnik.converter.common.Type.MSG;

/**
 * @author Alexey Zhytnik
 * @since 15-Sep-16
 */
public class PoiMsgConverter implements Converter<InputStream, ByteArrayOutputStream> {

    @Override
    public ByteArrayOutputStream convert(InputStream document) throws Exception {
        MAPIMessage message = new MAPIMessage(document);
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isSupported(Type type) {
        return type == MSG;
    }

    @Override
    public String toString() {
        return "Apache POI msg to pdf converter";
    }
}
