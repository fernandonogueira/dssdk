package unifor.dssdk.message.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unifor.dssdk.message.BaseParam;
import unifor.dssdk.message.DefaultMessage;
import unifor.dssdk.message.DefaultParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fernando Nogueira
 * @since 11/10/16 1:12 AM
 */
public class DefaultMessageParser extends AbstractMessageParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMessageParser.class);

    public DefaultMessage parseMessage(String message) {
        DefaultMessage msg = new DefaultMessage();

        if (message != null && !message.isEmpty()) {
            int index = message.indexOf("|");
            if (index != -1) {
                String methodName = message.substring(0, index);
                msg.setMethod(methodName);

                String tempStr = message.substring(index + 1, message.length());

                List<BaseParam> params = resolveParams(tempStr);

                msg.setParams(params);
                return msg;
            }
        }

        return null;
    }

    private List<BaseParam> resolveParams(String tempStr) {

        List<BaseParam> params = new ArrayList<>();

        String[] commaSplit = tempStr.split("\\|");

        for (String paramEntry : commaSplit) {
            LOGGER.info("Parsing received param: {}", paramEntry);
            String[] paramSplit = paramEntry.split(":");

            String paramName = paramSplit[0];
            String paramVal = paramSplit[1];

            DefaultParam defaultParam = new DefaultParam();
            defaultParam.setValue(paramVal);
            defaultParam.setName(paramName);
            params.add(defaultParam);
        }

        return params;
    }

}
