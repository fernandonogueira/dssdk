package unifor.dssdk.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseSdk implements DSSdk {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseSdk.class);

    /**
     * Remote defaultTargetAddress
     */
    private String defaultTargetAddr;

    private int localPort = 5654;

    @Override
    public void setDefaultTargetAddr(String defaultTargetAddr) {
        this.defaultTargetAddr = defaultTargetAddr;
    }

    @Override
    public String getDefaultTargetAddr() {
        return defaultTargetAddr;
    }

    @Override
    public int getLocalPort() {
        return localPort;
    }

    @Override
    public void setLocalPort(int localPort) {
        this.localPort = localPort;
    }
}
