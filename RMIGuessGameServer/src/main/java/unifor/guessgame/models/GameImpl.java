package unifor.guessgame.models;

import unifor.guessgame.GuessGameDatabase;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Fernando Nogueira
 * @since 11/27/16 8:41 PM
 */
public class GameImpl implements Game {

    private List<Player> players;

    private Map<String, Long> playerIdScoreMap;
    private String currentQuestion;

    public GameImpl() throws RemoteException {
        super();
        this.playerIdScoreMap = new HashMap<>();
        this.players = new ArrayList<>();
    }

    @Override
    public synchronized Player joinGame(String playerName) throws RemoteException {
        PlayerImpl p = new PlayerImpl(playerName);
        if (!playerAlreadyJoined(p)) {
            players.add(p);
        } else {
            Player oldPlayer = getAlreadyJoinedPlayerByName(playerName);
            System.out.println("Player rejoined: " + playerName);
            return oldPlayer;
        }

        System.out.println("Player: " + playerName + " joined! Id:" + p.getUuid());
        return p;
    }

    @Override
    public Long getScoreByPlayerId(String playerId) throws RemoteException {
        if (playerIdScoreMap.containsKey(playerId)) {
            return playerIdScoreMap.get(playerId);
        }
        return 0L;
    }

    @Override
    public synchronized String getQuestion() throws RemoteException {

        if (currentQuestion == null) {
            this.currentQuestion = GuessGameDatabase.getRandomQuestion();
        }

        return currentQuestion;
    }

    @Override
    public boolean answer(String playerId, String question, String answer) throws RemoteException {

        if (question.equals(currentQuestion)) {
            boolean correct = GuessGameDatabase.isCorrect(currentQuestion, answer);
            if (correct) {
                this.currentQuestion = GuessGameDatabase.getRandomQuestion();
                increasePlayerScore(playerId);
                return true;
            }
        }

        return false;
    }

    private synchronized void increasePlayerScore(String playerId) {
        if (!playerIdScoreMap.containsKey(playerId)) {
            playerIdScoreMap.put(playerId, 0L);
        }
        playerIdScoreMap.put(playerId, playerIdScoreMap.get(playerId) + 1L);
    }

    private Player getAlreadyJoinedPlayerByName(String playerName) throws RemoteException {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(playerName)) {
                return player;
            }
        }
        return null;
    }

    private synchronized boolean playerAlreadyJoined(Player p) throws RemoteException {
        for (Player player : players) {
            if (player.getName().equalsIgnoreCase(p.getName())) {
                return true;
            }
        }
        return false;
    }

}
