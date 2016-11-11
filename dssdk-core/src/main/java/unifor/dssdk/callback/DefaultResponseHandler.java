package unifor.dssdk.callback;

import unifor.dssdk.message.DefaultMessage;

import java.io.IOException;

/**
 * @author Fernando Nogueira
 * @since 11/11/16 8:08 PM
 */
public class DefaultResponseHandler implements ResponseHandler<DefaultMessage> {

    @Override
    public void respond(DefaultMessage message) throws IOException {
    }

    @Override
    public void done() {
    }
}
