package unifor.builder;

import unifor.BaseSdk;
import unifor.TCPSdk;
import unifor.UDPSdk;
import unifor.callback.MessageCallback;
import unifor.exception.InvalidConfigurationException;

import java.util.List;

public class SdkFactoryBuilder {

    private boolean udp;
    private List<String> addresses;
    private MessageCallback callback;

    public void udp() {
        this.udp = true;
    }

    public void callback(MessageCallback messageCallback) {
        this.callback = messageCallback;
    }

    public void addresses(List<String> addresses) {
        this.addresses = addresses;
    }

    public BaseSdk build()
            throws InvalidConfigurationException {

        validate();

        BaseSdk sdk;
        if (udp) {
            sdk = new UDPSdk();
        } else {
            sdk = new TCPSdk();
        }

        sdk.setAddresses(addresses);
        sdk.setMessageReceiverCallback(callback);

        return sdk;
    }

    private void validate() throws InvalidConfigurationException {
        if (addresses == null || addresses.isEmpty()) {
            throw new InvalidConfigurationException();
        }
    }

}
