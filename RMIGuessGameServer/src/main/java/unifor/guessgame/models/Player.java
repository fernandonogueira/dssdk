package unifor.guessgame.models;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Fernando Nogueira
 * @since 11/27/16 8:56 PM
 */
public interface Player extends Remote, Serializable {
    String getUuid() throws RemoteException;

    void setUuid(String uuid) throws RemoteException;

    void setName(String name) throws RemoteException;

    String getName() throws RemoteException;
}
