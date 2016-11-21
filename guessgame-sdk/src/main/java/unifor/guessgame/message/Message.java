package unifor.guessgame.message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Fernando Nogueira
 * @since 11/10/16 1:12 AM
 */
public class Message {

    public static final String END_OF_MSG = "%!@#";

    private String fromHost;

    private int fromPort;

    private String toHost;

    private int toPort;

    private String method;

    private List<Param> params;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

    public String getToHost() {
        return toHost;
    }

    public void setToHost(String toHost) {
        this.toHost = toHost;
    }

    public int getToPort() {
        return toPort;
    }

    public void setToPort(int toPort) {
        this.toPort = toPort;
    }

    public String getFromHost() {
        return fromHost;
    }

    public void setFromHost(String fromHost) {
        this.fromHost = fromHost;
    }

    public int getFromPort() {
        return fromPort;
    }

    public void setFromPort(int fromPort) {
        this.fromPort = fromPort;
    }

    @Override
    public String toString() {
        return "Message{" +
                "fromHost='" + fromHost + '\'' +
                ", fromPort=" + fromPort +
                ", toHost='" + toHost + '\'' +
                ", toPort=" + toPort +
                ", method='" + method + '\'' +
                ", params=" + params +
                '}';
    }

    public String prepareToTransmit() {
        List<Param> params = getParams();

        String str = getMethod() + "|";
        if (params != null && !params.isEmpty()) {

            boolean firstParam = true;

            for (Param param : params) {
                if (!firstParam) {
                    str += "|";
                }
                str += param.string();
                firstParam = false;
            }
        }

        return str + END_OF_MSG;
    }

    public static Message parse(String msg) {

        String[] split = msg.split("\\|");
        String parsedMethod = split[0];

        Message msgObj = new Message();
        msgObj.setMethod(parsedMethod);

        List<Param> paramsList = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                msgObj.setMethod(split[i]);
            } else {
                Param parsedParam = Param.parseParam(split[i]);
                if (parsedParam != null) {
                    paramsList.add(parsedParam);
                }

            }
        }

        if (!paramsList.isEmpty()) {
            msgObj.setParams(paramsList);
        }

        return msgObj;
    }


}
