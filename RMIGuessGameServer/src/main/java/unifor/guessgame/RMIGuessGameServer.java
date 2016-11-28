package unifor.guessgame;

import unifor.guessgame.models.Game;
import unifor.guessgame.models.GameImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author Fernando Nogueira
 * @since 11/27/16 8:41 PM
 */
public class RMIGuessGameServer {

    public static void main(String[] args)
            throws RemoteException, MalformedURLException, AlreadyBoundException {

//        LocateRegistry.createRegistry(1099);

//        System.setProperty("java.rmi.server.codebase", clazz.getProtectionDomain().getCodeSource().getLocation().toString());

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            String name = "Game";
            Game engine = new GameImpl();
            Game stub =
                    (Game) UnicastRemoteObject.exportObject(engine, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("Game registered...");

        } catch (Exception e) {
            System.err.println("exception:");
            e.printStackTrace();
        }
    }
}
