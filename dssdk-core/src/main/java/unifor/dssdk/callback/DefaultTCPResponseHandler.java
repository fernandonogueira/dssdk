package unifor.dssdk.callback;

import java.net.Socket;

public class DefaultTCPResponseHandler extends DefaultResponseHandler {

    private final Socket socket;

    public DefaultTCPResponseHandler(Socket socket) {
        this.socket = socket;
    }

}
