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

    /**
     * Prepare the unifor.dssdk.message to be transmitted
     *
     * @return
     */
    public abstract String string();

    @Override
    public String toString() {
        return "BaseMessage{}";
    }
}
