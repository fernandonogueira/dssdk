package unifor.dssdk;

import unifor.dssdk.builder.SdkBuilder;
import unifor.dssdk.callback.ResponseHandler;
import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.core.DSSdk;
import unifor.dssdk.exception.InvalidConfigurationException;
import unifor.dssdk.message.BaseMessage;

public class SampleServer {

    public static void main(String[] args) throws InvalidConfigurationException {
        DSSdk sdk = new SdkBuilder()
                .defaultTargetAddress("localhost:5654")
                .callback(new MessageCallback() {
                    @Override
                    public <T extends BaseMessage> void messageReceived(T message,
                                                                        ResponseHandler responseHandler) {

                        responseHandler.done();
                        System.out.println("Message received!");
                        System.out.println(message);
                    }
                }).build();

        sdk.listen();

    }

}
