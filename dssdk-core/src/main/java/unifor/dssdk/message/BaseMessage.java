package unifor.dssdk.message;

import java.util.List;

/**
 * @author Fernando Nogueira
 * @since 11/3/16 1:40 PM
 */
public abstract class BaseMessage {

    /**
     * Method name
     *
     * @return
     */
    public abstract String getMethod();

    /**
     * Retrieve params
     *
     * @return
     */
    public abstract List<BaseParam> getParams();


    public abstract String getFrom();

    public abstract String getTo();

    @Override
    public String toString() {
        return "BaseMessage{}";
    }

    /**
     * Prepare the unifor.dssdk.message to be transmitted
     *
     * @return
     */
    public String string() {
        List<BaseParam> params = getParams();

        String str = getMethod() + "|";
        if (params != null && !params.isEmpty()) {

            boolean firstParam = true;

            for (BaseParam param : params) {
                if (!firstParam) {
                    str += "|";
                }
                str += param.string();
//                str += param.getName() + ":" + param.getValue();
                firstParam = false;
            }
        }

        return str;
    }
}
