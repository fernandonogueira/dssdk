package unifor;

import unifor.callback.MessageCallback;
import unifor.message.BaseMessage;

/**
 * @author Fernando Nogueira
 * @since 11/3/16 1:53 PM
 */
public class UDPSdk extends BaseSdk {

    private MessageCallback callback;

    public <T extends BaseMessage> void send(T send) {

    }

    public void receive() {

    }

    public MessageCallback getMessageReceiverCallback() {
        return callback;
    }

    public void setMessageReceiverCallback(MessageCallback messageReceiverCallback) {
        this.callback = messageReceiverCallback;
    }

}
