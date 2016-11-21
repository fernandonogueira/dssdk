package unifor.guessgame.builder;

import unifor.guessgame.server.GenericServer;
import unifor.guessgame.server.tcp.GenericTCPServer;

public class ServerBuilder {

    private int port;

    private boolean udp;

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

    public GenericServer build() {
        if (udp) {
            return null;
        } else {
            GenericTCPServer server = new GenericTCPServer();
            server.setServerPort(port);
            return server;
        }
    }
}
