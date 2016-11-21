package unifor.guessgame.builder;

import unifor.guessgame.server.GenericServer;
import unifor.guessgame.server.ServerCommandHandler;
import unifor.guessgame.server.tcp.GenericTCPServer;

public class ServerBuilder {

    private int port;

    private boolean udp;

    private ServerCommandHandler serverCommandHandler;

    public int getPort() {
        return port;
    }

    public ServerBuilder setPort(int port) {
        this.port = port;
        return this;
    }

    public boolean isUdp() {
        return udp;
    }

    public ServerBuilder setUdp(boolean udp) {
        this.udp = udp;
        return this;
    }

    public ServerCommandHandler getServerCommandHandler() {
        return serverCommandHandler;
    }

    public ServerBuilder setServerCommandHandler(ServerCommandHandler serverCommandHandler) {
        this.serverCommandHandler = serverCommandHandler;
        return this;
    }

    public GenericServer build() {
        if (udp) {
            return null;
        } else {
            GenericTCPServer server = new GenericTCPServer();
            server.setServerCommandHandler(getServerCommandHandler());
            server.setServerPort(port);
            return server;
        }
    }
}
