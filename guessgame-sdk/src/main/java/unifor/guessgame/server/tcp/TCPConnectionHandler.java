package unifor.guessgame.server.tcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unifor.guessgame.message.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPConnectionHandler implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(TCPConnectionHandler.class);

    private static final int EOF = -1;

    private final Socket socket;
    private final String clientId;
    private final GenericTCPServer server;
    private String buffer = "";

    public TCPConnectionHandler(GenericTCPServer server, Socket socket, String clientId) {
        this.socket = socket;
        this.clientId = clientId;
        this.server = server;
    }

    public void handleConnection(Socket socket) {

        byte[] readBuffer = new byte[1024];

        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            int readBytes;
            while ((EOF != (readBytes = is.read(readBuffer)))) {
                String receivedStr = new String(readBuffer, 0, readBytes);

                LOGGER.info("String received from clientId: [{}]; [{}];", clientId, receivedStr);

                addToBuffer(receivedStr);

                if (buffer.contains(Message.END_OF_MSG)) {
                    List<Message> msgs = resolveMessages();
                    LOGGER.info("Parsed msgs: [{}]", msgs);
                }

            }

        } catch (IOException e) {
            LOGGER.error("Error occurred!", e);
            e.printStackTrace();
        } finally {

        }
    }

    private synchronized List<Message> resolveMessages() {

        List<Message> list = new ArrayList<>();

        if (buffer.contains(Message.END_OF_MSG)) {
            String[] msgs = buffer.split(Message.END_OF_MSG);
            for (String msg : msgs) {
                LOGGER.info("Message: {}", msg);

                list.add(parseMsg(msg));
            }
        }

        int lastMsgIndex = buffer.lastIndexOf(Message.END_OF_MSG);
        buffer = buffer.substring(lastMsgIndex + Message.END_OF_MSG.length());
        LOGGER.info("Buffer status: {}", buffer);


        return list;
    }

    private Message parseMsg(String msgStr) {
        Message msg = Message.parse(msgStr);
        if (msg != null) {
            msg.setFromHost(socket.getInetAddress().getHostName());
            msg.setFromPort(socket.getPort());
        }
        return msg;
    }

    private synchronized void addToBuffer(String receivedStr) {
        buffer += receivedStr;
    }

    @Override
    public void run() {
        handleConnection(socket);
    }
}