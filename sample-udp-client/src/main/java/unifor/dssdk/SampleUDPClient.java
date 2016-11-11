package unifor.dssdk;

import unifor.dssdk.builder.SdkBuilder;
import unifor.dssdk.callback.ResponseHandler;
import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.core.DSSdk;
import unifor.dssdk.exception.InvalidConfigurationException;
import unifor.dssdk.message.BaseMessage;
import unifor.dssdk.message.BaseParam;
import unifor.dssdk.message.DefaultMessage;
import unifor.dssdk.message.DefaultParam;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SampleUDPClient {

    public static void main(String[] args) throws InvalidConfigurationException, IOException {

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
                })
                .udp()
                .build();


        DefaultMessage msg = new DefaultMessage();

        msg.setMethod("sugerirLetra");

        List<BaseParam> paramsToSend = new ArrayList<>();

        DefaultParam param1 = new DefaultParam();
        param1.setName("param1");
        param1.setValue("value1");
        paramsToSend.add(param1);

        DefaultParam param2 = new DefaultParam();
        param2.setName("param2");
        param2.setValue("value2");

        paramsToSend.add(param2);

        msg.setParams(paramsToSend);

        System.out.println("Sending message... :" + msg.string());
        sdk.send(msg);
    }
}
