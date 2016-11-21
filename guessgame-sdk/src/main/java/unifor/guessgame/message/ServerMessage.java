package unifor.guessgame.message;

/**
 * Message, after being received in the backend
 *
 * @author Fernando Nogueira
 * @since 11/21/16 1:08 AM
 */
public class ServerMessage extends Message {

    private String clientId;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public static ServerMessage fromMessage(Message msg) {
        ServerMessage serverMsg = new ServerMessage();
        serverMsg.setFromPort(msg.getFromPort());
        serverMsg.setMethod(msg.getMethod());
        serverMsg.setParams(msg.getParams());
        serverMsg.setFromHost(msg.getFromHost());
        serverMsg.setToHost(msg.getToHost());
        serverMsg.setToPort(msg.getToPort());
        return serverMsg;
    }
}
