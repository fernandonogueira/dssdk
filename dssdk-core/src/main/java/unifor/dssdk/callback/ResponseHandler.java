package unifor.dssdk.callback;

import unifor.dssdk.message.BaseMessage;

import java.io.IOException;

public interface ResponseHandler<T extends BaseMessage> {

    /**
     * Complete the request sending a respond
     *
     * @param message
     */
    void respond(T message) throws IOException;

    /**
     * Completes the request and do not send any respond
     */
    void done();

}
