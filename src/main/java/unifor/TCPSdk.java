package unifor;

import unifor.callback.MessageCallback;
import unifor.message.BaseMessage;
import unifor.message.BaseParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fernando Nogueira
 * @since 11/3/16 1:53 PM
 */
public class TCPSdk extends BaseSdk {

    private MessageCallback messageCallback;

    public <T extends BaseMessage> void send(T send) {

    }

    public void receive() {
        // Receive message...

        // Parse

        // Send to callback
        getMessageReceiverCallback().messageReceived(new BaseMessage() {
            public String getMethod() {
                return "method";
            }

            public List<BaseParam> getParams() {
                return new ArrayList<BaseParam>();
            }

            public String string() {
                return "teste";
            }
        });
    }

    public MessageCallback getMessageReceiverCallback() {
        return messageCallback;
    }

    public void setMessageReceiverCallback(MessageCallback messageReceiverCallback) {
        this.messageCallback = messageReceiverCallback;
    }
}
