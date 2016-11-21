package unifor.guessgame.server;

import unifor.guessgame.message.Message;
import unifor.guessgame.message.ServerMessage;

import java.io.IOException;

public abstract class GenericServer {

    private ServerCommandHandler serverCommandHandler;

    private int serverPort;

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public int getServerPort() {
        return serverPort;
    }

    public abstract void listen() throws IOException;

    public ServerCommandHandler getServerCommandHandler() {
        return serverCommandHandler;
    }

    public void setServerCommandHandler(ServerCommandHandler serverCommandHandler) {
        this.serverCommandHandler = serverCommandHandler;
    }

    /**
     * Handles received message
     *
     * @param message
     * @return
     */
    public Message handleCommand(ServerMessage message) {
        return serverCommandHandler.handleCommand(message);
    }

}
