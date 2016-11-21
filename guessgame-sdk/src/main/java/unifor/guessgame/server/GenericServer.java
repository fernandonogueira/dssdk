package unifor.guessgame.server;

import java.io.IOException;

public abstract class GenericServer {

    private int serverPort;

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public int getServerPort() {
        return serverPort;
    }

    public abstract void listen() throws IOException;

}
