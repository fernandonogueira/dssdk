package unifor.dssdk.message;

import java.util.List;

/**
 * @author Fernando Nogueira
 * @since 11/10/16 1:12 AM
 */
public class DefaultMessage extends BaseMessage {

    private String from;

    private String to;

    private String method;

    private List<BaseParam> params;

    @Override
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public List<BaseParam> getParams() {
        return params;
    }

    public void setParams(List<BaseParam> params) {
        this.params = params;
    }

    @Override
    public String string() {
        List<BaseParam> params = getParams();

        String str = getMethod() + "|";
        if (params != null && !params.isEmpty()) {

            boolean firstParam = true;

            for (BaseParam param : params) {
                if (!firstParam) {
                    str += "|";
                }
                str += param.getName() + ":" + param.getValue();
                firstParam = false;
            }
        }

        return str;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "DefaultMessage{" +
                "method='" + method + '\'' +
                ", params=" + params +
                "} " + super.toString();
    }
}
