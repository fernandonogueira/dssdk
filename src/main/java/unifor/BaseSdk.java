package unifor;

import unifor.callback.MessageCallback;
import unifor.message.BaseMessage;

import java.util.List;

/**
 * @author Fernando Nogueira
 * @since 11/3/16 1:33 PM
 */
public abstract class BaseSdk {

    /**
     * Remote addresses
     */
    private List<String> addresses;

    /**
     * Send a message
     *
     * @param send message to be sent
     * @param <T>  Message Type
     */
    public abstract <T extends BaseMessage> void send(T send);

    /**
     * Receive a message
     *
     * @param <T> Message type
     * @return Message received
     */
    public abstract void receive();

    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    public abstract MessageCallback getMessageReceiverCallback();

    public abstract void setMessageReceiverCallback(MessageCallback messageReceiverCallback);
}
