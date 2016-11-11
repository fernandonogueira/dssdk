package unifor.dssdk.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.core.tcp.TCPMessageHandler;
import unifor.dssdk.message.BaseMessage;
import unifor.dssdk.message.parser.DefaultMessageParser;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Fernando Nogueira
 * @since 11/3/16 1:53 PM
 */
public class TCPSdk extends BaseSdk {

    private static final Logger LOGGER = LoggerFactory.getLogger(TCPSdk.class);

    private MessageCallback messageCallback;
    private boolean running;

    private DefaultMessageParser messageParser = new DefaultMessageParser();

    public <T extends BaseMessage> void send(T send) throws IOException {
        Socket socket = new Socket();
        // TODO support address by message
        String defaultAddr = getDefaultTargetAddr();
        String[] split = defaultAddr.split(":");
        socket.connect(new InetSocketAddress(split[0], Integer.parseInt(split[1])));
        socket.getOutputStream().write(send.string().getBytes());
    }

    public MessageCallback getMessageReceiverCallback() {
        return messageCallback;
    }

    public void setMessageReceiverCallback(MessageCallback messageReceiverCallback) {
        this.messageCallback = messageReceiverCallback;
    }

    @Override
    public void listen() {
        this.running = true;
        try {
            LOGGER.info("Initiating server...");
            ServerSocket serverSocket = new ServerSocket(getLocalPort());
            LOGGER.info("Accepting new connections on port: {}...", getLocalPort());
            while (running) {
                Socket socket = serverSocket.accept();
                TCPMessageHandler handler = new TCPMessageHandler(socket, messageParser, messageCallback);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void kill() {
        this.running = false;
    }
}
