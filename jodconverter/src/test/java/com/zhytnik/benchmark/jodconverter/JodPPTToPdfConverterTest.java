package com.zhytnik.benchmark.jodconverter;

import com.zhytnik.benchmark.common.FlowConverter;
import com.zhytnik.benchmark.test.FlowConverterTest;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import static com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection.DEFAULT_HOST;
import static com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection.DEFAULT_PORT;
import static com.zhytnik.benchmark.test.Resources.PPT_RESOURCE;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 31.08.2016
 */
public class JodPPTToPdfConverterTest extends FlowConverterTest {

    @Override
    protected String getResource() {
        return PPT_RESOURCE;
    }

    @Override
    protected FlowConverter<InputStream> getConverter() {
        return new JodPPTToPdfConverter();
    }

    @Test
    public void worksWithLibreOffice() throws IOException {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(DEFAULT_HOST, DEFAULT_PORT), 1_000);
            assertThat(socket.isConnected()).isTrue();
            socket.close();
        }
    }
}
