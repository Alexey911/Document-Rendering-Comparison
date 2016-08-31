package com.zhytnik.benchmark.documents4j;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import com.zhytnik.benchmark.common.ConversationException;
import com.zhytnik.benchmark.common.FlowConverter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
abstract class Docs4jConverter implements FlowConverter<InputStream> {

    private IConverter converter = installConverter();

    @Override
    public ByteArrayOutputStream convert(InputStream flow) throws Exception {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        boolean conversion = converter
                .convert(flow).as(getType())
                .to(output).as(DocumentType.PDF)
                .execute();

        if (!conversion) throw new ConversationException();
        return output;
    }

    protected abstract DocumentType getType();

    private static IConverter installConverter() {
        return LocalConverter.builder()
                .baseFolder(new File("E:/exist"))
                .workerPool(1, 1, 1, TimeUnit.SECONDS)
                .processTimeout(5, TimeUnit.SECONDS)
                .build();
    }
}
