package com.zhytnik.converter.groupdocs;

import com.zhytnik.converter.common.Type;
import com.zhytnik.converter.test.ConverterTest;

import static com.zhytnik.converter.common.Type.DWG;

/**
 * @author Alexey Zhytnik
 * @since 13-Sep-16
 */
public class AsposeDwgConverterTest extends ConverterTest {

    @Override
    protected Type getType() {
        return DWG;
    }

    @Override
    protected AsposeDwgConverter getConverter() {
        return new AsposeDwgConverter();
    }
}