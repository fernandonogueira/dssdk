package unifor.callback;

import unifor.message.BaseMessage;

/**
 * @author Fernando Nogueira
 * @since 11/3/16 1:59 PM
 */
public interface MessageCallback {

    <T extends BaseMessage> void messageReceived(T message);

}
