package unifor.dssdk.builder;

import unifor.dssdk.callback.MessageCallback;
import unifor.dssdk.core.BaseSdk;
import unifor.dssdk.core.DSSdk;
import unifor.dssdk.core.TCPSdk;
import unifor.dssdk.core.UDPSdk;
import unifor.dssdk.exception.InvalidConfigurationException;

public class SdkBuilder {

    private boolean udp;
    private String defaultTargetAddr;
    private MessageCallback callback;

    public SdkBuilder() {
    }

    public SdkBuilder udp() {
        this.udp = true;
        return this;
    }

    public SdkBuilder callback(MessageCallback messageCallback) {
        this.callback = messageCallback;
        return this;
    }

    public SdkBuilder defaultTargetAddress(String address) {
        this.defaultTargetAddr = address;
        return this;
    }

    public DSSdk build()
            throws InvalidConfigurationException {

        validate();

        BaseSdk sdk;
        if (udp) {
            sdk = new UDPSdk();
        } else {
            sdk = new TCPSdk();
        }

        sdk.setDefaultTargetAddr(defaultTargetAddr);
        sdk.setMessageReceiverCallback(callback);

        return sdk;
    }

    private void validate() throws InvalidConfigurationException {
        if (defaultTargetAddr == null || defaultTargetAddr.isEmpty()) {
            throw new InvalidConfigurationException();
        }
    }

}
