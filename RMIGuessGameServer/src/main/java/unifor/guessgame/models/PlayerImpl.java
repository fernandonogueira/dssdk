package unifor.guessgame.models;

import java.rmi.RemoteException;
import java.util.UUID;

/**
 * @author Fernando Nogueira
 * @since 11/27/16 8:43 PM
 */
public class PlayerImpl implements Player {

    private String uuid;
    private String name;

    public PlayerImpl(String name) {
        super();
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
    }

    @Override
    public String getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    @Override
    public String getName() throws RemoteException {
        return this.name;
    }

    @Override
    public String toString() {
        return "PlayerImpl{" +
                "uuid='" + uuid + '\'' +
                '}';
    }
}
