package unifor.dssdk.core.udp;

import unifor.dssdk.callback.DefaultUDPResponseHandler;
import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.message.DefaultMessage;
import unifor.dssdk.message.parser.DefaultMessageParser;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPMessageHandler implements Runnable {

    private final MessageCallback callback;
    private final DefaultMessageParser parser;
    private final DatagramSocket serverSocket;
    private final DatagramPacket packet;

    public UDPMessageHandler(DatagramSocket serverSocket,
                             DatagramPacket receivePacket,
                             DefaultMessageParser parser,
                             MessageCallback callback) {
        this.serverSocket = serverSocket;
        this.packet = receivePacket;
        this.callback = callback;
        this.parser = parser;
    }

    @Override
    public void run() {
        handleMessage();
    }

    private void handleMessage() {
        byte[] bytes = packet.getData();
        String str = new String(bytes, 0, packet.getLength());
        DefaultMessage message = parser.parseMessage(str);
        DefaultUDPResponseHandler respHandler = new DefaultUDPResponseHandler(serverSocket, packet);
        callback.messageReceived(message, respHandler);
    }

}
