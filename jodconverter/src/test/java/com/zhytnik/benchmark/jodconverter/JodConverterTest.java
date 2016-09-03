package com.zhytnik.benchmark.jodconverter;

import com.zhytnik.benchmark.test.ConverterTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import static com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection.DEFAULT_HOST;
import static com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection.DEFAULT_PORT;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexey Zhytnik
 * @since 03-Sep-16
 */
abstract class JodConverterTest extends ConverterTest {

    @Test
    void worksWithLibreOffice() throws IOException {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(DEFAULT_HOST, DEFAULT_PORT), 1_000);
            assertThat(socket.isConnected()).isTrue();
            socket.close();
        }
    }
}
