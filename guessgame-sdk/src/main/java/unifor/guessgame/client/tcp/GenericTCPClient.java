package unifor.guessgame.client.tcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unifor.guessgame.client.GenericClient;
import unifor.guessgame.message.Message;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Fernando Nogueira
 * @since 11/20/16 10:42 PM
 */
public class GenericTCPClient extends GenericClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericTCPClient.class);

    private Socket socket;

    @Override
    public void sendMessage(Message message) {
        try {
            if (!connected()) {
                connect();
            }
            OutputStream os = socket.getOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            bos.write(message.prepareToTransmit().getBytes("UTF-8"));
            bos.flush();
        } catch (IOException e) {
            LOGGER.error("Error sending message", e);
        }
    }

    private void connect() throws IOException {
        socket = new Socket(getServerHost(), getServerPort());
    }

    private synchronized boolean connected() {
        return socket != null && socket.isConnected();
    }
}
