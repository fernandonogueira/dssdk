package unifor.dssdk.message.parser;

import unifor.dssdk.message.BaseParam;
import unifor.dssdk.message.DefaultMessage;

import java.util.Arrays;
import java.util.List;

/**
 * @author Fernando Nogueira
 * @since 11/10/16 1:12 AM
 */
public class DefaultMessageParser extends AbstractMessageParser {

    public DefaultMessage parseMessage(String message) {
        DefaultMessage msg = new DefaultMessage();

        if (message != null && !message.isEmpty()) {
            int index = message.indexOf("|");
            if (index != -1) {
                String methodName = message.substring(0, index);
                msg.setMethod(methodName);

                String tempStr = message.substring(index, message.length());

                List<BaseParam> params = resolveParams(tempStr);

                // TODO retrieveParams =
                return msg;
            }
        }

        return null;
    }

    private List<BaseParam> resolveParams(String tempStr) {

        String[] commaSplit = tempStr.split("|");
        System.out.println(Arrays.toString(commaSplit));

        return null;
    }

}
