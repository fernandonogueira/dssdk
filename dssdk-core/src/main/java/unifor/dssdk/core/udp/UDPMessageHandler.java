package unifor.dssdk.core.udp;

import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.message.DefaultMessage;
import unifor.dssdk.message.parser.DefaultMessageParser;

public class UDPMessageHandler implements Runnable {

    private final MessageCallback callback;
    private final byte[] bytes;
    private final DefaultMessageParser parser;

    public UDPMessageHandler(byte[] bytes, DefaultMessageParser parser, MessageCallback callback) {
        this.bytes = bytes;
        this.callback = callback;
        this.parser = parser;
    }

    @Override
    public void run() {
        handleMessage();
    }

    private void handleMessage() {
        String str = new String(bytes);
        DefaultMessage message = parser.parseMessage(str);
        callback.messageReceived(message);
    }

}
