package unifor.dssdk.core;

import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.message.BaseMessage;

import java.io.IOException;

public interface DSSdk {
    /**
     * Send a unifor.dssdk.message
     *
     * @param send unifor.dssdk.message to be sent
     * @param <T>  Message Type
     */
    <T extends BaseMessage> void send(T send) throws IOException;

    /**
     * Receive a unifor.dssdk.message
     *
     * @param <T> Message type
     * @return Message received
     */
    void receive();

    void setDefaultTargetAddr(String defaultTargetAddr);

    String getDefaultTargetAddr();

    MessageCallback getMessageReceiverCallback();

    void setMessageReceiverCallback(MessageCallback messageReceiverCallback);

    int getLocalPort();

    void setLocalPort(int localPort);

    void listen();

    /**
     * Stops this sdk instance. No new commands will work after calling this method
     */
    void kill();
}
