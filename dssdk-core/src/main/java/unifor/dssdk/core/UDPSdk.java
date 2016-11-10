package unifor.dssdk.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.message.BaseMessage;

/**
 * @author Fernando Nogueira
 * @since 11/3/16 1:53 PM
 */
public class UDPSdk extends BaseSdk {

    private static final Logger LOGGER = LoggerFactory.getLogger(UDPSdk.class);

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

    @Override
    public void listen() {

    }

    @Override
    public void kill() {

    }

}
