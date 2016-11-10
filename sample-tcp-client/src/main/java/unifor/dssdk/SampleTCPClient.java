package unifor.dssdk;

import unifor.dssdk.builder.SdkBuilder;
import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.core.DSSdk;
import unifor.dssdk.exception.InvalidConfigurationException;
import unifor.dssdk.message.BaseMessage;
import unifor.dssdk.message.DefaultMessage;

import java.io.IOException;

public class SampleTCPClient {

    public static void main(String[] args) throws InvalidConfigurationException, IOException {

        DSSdk sdk = new SdkBuilder()
                .defaultTargetAddress("localhost:5654")
                .callback(new MessageCallback() {
                    @Override
                    public <T extends BaseMessage> void messageReceived(T message) {
                        System.out.println("Message received!");
                        System.out.println(message);
                    }
                }).build();


        DefaultMessage msg = new DefaultMessage();

        msg.setMethod("sugerirLetra");
        sdk.send(msg);
    }
}
