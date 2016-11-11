package unifor.dssdk.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.core.udp.UDPMessageHandler;
import unifor.dssdk.message.BaseMessage;
import unifor.dssdk.message.parser.DefaultMessageParser;
import unifor.dssdk.utils.InetUtils;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Fernando Nogueira
 * @since 11/3/16 1:53 PM
 */
public class UDPSdk extends BaseSdk {

    private static final Logger LOGGER = LoggerFactory.getLogger(UDPSdk.class);

    private DefaultMessageParser messageParser = new DefaultMessageParser();

    private MessageCallback callback;
    private boolean running = true;

    public <T extends BaseMessage> void send(T send) {

        String hostname;
        int port;
        if (send.getTo() != null) {
            port = InetUtils.getPortFromAddr(send.getTo());
            hostname = InetUtils.getHostnameFromAddr(send.getTo());
        } else {
            port = InetUtils.getPortFromAddr(getDefaultTargetAddr());
            hostname = InetUtils.getHostnameFromAddr(getDefaultTargetAddr());
        }

        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName(hostname);
            byte[] sendData;

            sendData = send.string().getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            clientSocket.send(sendPacket);
        } catch (IOException e) {
            LOGGER.error("Error trying to send message. Message: {}", send);
        }


    }

    public MessageCallback getMessageReceiverCallback() {
        return callback;
    }

    public void setMessageReceiverCallback(MessageCallback messageReceiverCallback) {
        this.callback = messageReceiverCallback;
    }

    @Override
    public void listen() {

        try {
            DatagramSocket serverSocket = new DatagramSocket(getLocalPort());
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                byte[] receivedData = receivePacket.getData();
                UDPMessageHandler handler = new UDPMessageHandler(receivedData, messageParser, callback);
                new Thread(handler).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void kill() {
        running = false;
    }

}
