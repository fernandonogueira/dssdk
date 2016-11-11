package unifor.dssdk.core.tcp;

import org.apache.commons.io.IOUtils;
import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.message.DefaultMessage;
import unifor.dssdk.message.parser.DefaultMessageParser;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TCPMessageHandler implements Runnable {

    private final MessageCallback callback;
    private final Socket socket;
    private final DefaultMessageParser parser;

    public TCPMessageHandler(Socket socket, DefaultMessageParser parser, MessageCallback callback) {
        this.socket = socket;
        this.callback = callback;
        this.parser = parser;
    }

    @Override
    public void run() {
        handleMessage();
    }

    private void handleMessage() {
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = IOUtils.toByteArray(inputStream);
            String str = new String(bytes);
            DefaultMessage message = parser.parseMessage(str);
            callback.messageReceived(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
