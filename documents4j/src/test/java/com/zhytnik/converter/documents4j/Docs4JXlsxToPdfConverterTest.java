package com.zhytnik.converter.documents4j;

import com.zhytnik.converter.common.Type;

import static com.zhytnik.converter.common.Type.XLSX;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
public class Docs4JXlsxToPdfConverterTest extends Docs4jConverterTest {

    @Override
    protected Type getType() {
        return XLSX;
    }

    @Override
    protected Docs4JXlsxToPdfConverter getConverter() {
        return new Docs4JXlsxToPdfConverter();
    }
}
