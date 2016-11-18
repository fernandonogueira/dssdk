package unifor.hangman;

import unifor.dssdk.builder.SdkBuilder;
import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.callback.ResponseHandler;
import unifor.dssdk.core.DSSdk;
import unifor.dssdk.exception.InvalidConfigurationException;
import unifor.dssdk.message.BaseMessage;

public class HangmanServerSdk implements MessageCallback {

    public HangmanServerSdk() throws InvalidConfigurationException {
        init();
    }

    private void init() throws InvalidConfigurationException {
        DSSdk sdk = new SdkBuilder()
                .defaultTargetAddress("localhost:5654")
                .callback(this)
                .build();

        sdk.listen();
    }

    @Override
    public <T extends BaseMessage> void messageReceived(T message, ResponseHandler responseHandler) {
        responseHandler.done();
        System.out.println("Message received!");
        System.out.println(message);
    }
}
