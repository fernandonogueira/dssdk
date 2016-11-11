package unifor.dssdk.callback;

import unifor.dssdk.message.DefaultMessage;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DefaultUDPResponseHandler implements ResponseHandler<DefaultMessage> {

    private final DatagramPacket packet;
    private final DatagramSocket serverSocket;

    public DefaultUDPResponseHandler(DatagramSocket serverSocket, DatagramPacket packet) {
        this.packet = packet;
        this.serverSocket = serverSocket;
    }

    @Override
    public void respond(DefaultMessage message) throws IOException {
        byte[] bytesToRespond = message.string().getBytes();
        DatagramPacket respondPacket = new DatagramPacket(
                bytesToRespond, bytesToRespond.length, packet.getAddress(), packet.getPort());
        this.serverSocket.send(respondPacket);
    }

    @Override
    public void done() {
    }
}
