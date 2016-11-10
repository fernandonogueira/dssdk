package unifor.dssdk.message.parser;

import unifor.dssdk.message.DefaultMessage;

/**
 * @author Fernando Nogueira
 * @since 11/10/16 1:12 AM
 */
public class DefaultMessageParser {

    public DefaultMessage parseMessage(String message) {
        DefaultMessage msg = new DefaultMessage();

        if (message != null && !message.isEmpty()) {
            int index = message.indexOf("|");
            if (index != -1) {
                String methodName = message.substring(0, index);
                msg.setMethod(methodName);

                String tempStr = message.substring(index, message.length());
                // TODO retrieveParams =
                return msg;
            }
        }

        return null;
    }

}
