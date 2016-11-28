package unifor.guessgame;

import unifor.guessgame.models.Game;
import unifor.guessgame.models.Player;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 * @author Fernando Nogueira
 * @since 11/27/16 9:29 PM
 */
public class ClientMain {

    public static void main(String args[]) {


        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        System.out.println("Please enter your name:");

        Scanner s = new Scanner(System.in);
        String playerName = s.nextLine();

        try {
            String name = "Game";
            Registry registry = LocateRegistry.getRegistry("localhost");
            Game game = (Game) registry.lookup(name);

//            registry.rebind(name, stub);
            Player player = game.joinGame(playerName);

            System.out.println("player joined: " + player.getUuid());

            System.out.println("Your current score is: " + game.getScoreByPlayerId(player.getUuid()));

            while (true) {
                String question = game.getQuestion();
                System.out.println("Current Question: " + question);
                System.out.println("Answer the question: ");
                String answer = s.nextLine();
                boolean result = game.answer(player.getUuid(), question, answer);
                if (result) {
                    System.out.println("Your answer is correct!");
                }
                System.out.println("Current score: " + game.getScoreByPlayerId(player.getUuid()));
            }

        } catch (Exception e) {
            System.err.println("Exception:");
            e.printStackTrace();
        }
    }

}
