package unifor.guessgame.builder;

import unifor.guessgame.client.tcp.GenericTCPClient;

/**
 * @author Fernando Nogueira
 * @since 11/20/16 10:53 PM
 */
public class ClientBuilder {

    private String serverHost;

    private int serverPort;

    private boolean udp;

    public String getServerHost() {
        return serverHost;
    }

    public ClientBuilder setServerHost(String serverHost) {
        this.serverHost = serverHost;
        return this;
    }

    public int getServerPort() {
        return serverPort;
    }

    public ClientBuilder setServerPort(int serverPort) {
        this.serverPort = serverPort;
        return this;
    }

    public boolean isUdp() {
        return udp;
    }

    public ClientBuilder setUdp(boolean udp) {
        this.udp = udp;
        return this;
    }

    public GenericTCPClient build() {
        if (udp) {
            return null;
        } else {
            GenericTCPClient client = new GenericTCPClient();
            client.setServerPort(getServerPort());
            client.setServerHost(getServerHost());
            return client;
        }

    }

}
