package unifor.guessgame.client;

import unifor.guessgame.message.Message;

/**
 * @author Fernando Nogueira
 * @since 11/20/16 10:37 PM
 */
public abstract class GenericClient {

    private String serverHost;

    private int serverPort;

    public String getServerHost() {
        return serverHost;
    }

    public void setServerHost(String serverHost) {
        this.serverHost = serverHost;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public abstract void sendMessage(Message message);
}
