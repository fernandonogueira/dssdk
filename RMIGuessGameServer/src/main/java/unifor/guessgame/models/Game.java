package unifor.guessgame.models;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Fernando Nogueira
 * @since 11/27/16 8:54 PM
 */
public interface Game extends Serializable, Remote {
    Player joinGame(String playerName) throws RemoteException;

    Long getScoreByPlayerId(String playerId) throws RemoteException;

    String getQuestion() throws RemoteException;

    boolean answer(String playerId, String question, String answer) throws RemoteException;

}
