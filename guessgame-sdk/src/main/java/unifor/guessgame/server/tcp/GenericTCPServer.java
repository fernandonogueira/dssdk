package unifor.guessgame.server.tcp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unifor.guessgame.server.GenericServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * @author Fernando Nogueira
 * @since 11/20/16 10:17 PM
 */
public class GenericTCPServer extends GenericServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(GenericTCPServer.class);

    @Override
    public void listen() throws IOException {
        ServerSocket serverSocket = new ServerSocket(getServerPort());

        LOGGER.info("TCP server is listening on port {}... ", getServerPort());
        while (true) {
            Socket socket = serverSocket.accept();
            String clientId = UUID.randomUUID().toString();
            TCPConnectionHandler connHandler = new TCPConnectionHandler(this, socket, clientId);
            new Thread(connHandler).start();
        }

    }
}
