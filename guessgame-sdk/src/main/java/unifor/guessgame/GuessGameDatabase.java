package unifor.guessgame;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Fernando Nogueira
 * @since 11/21/16 1:00 AM
 */
public class GuessGameDatabase {

    private static Map<String, String> map = new HashMap<>();

    static {

        map.put("Pergunta 1", "azeitona");
        map.put("Pergunta 2", "pirulito");
        map.put("Pergunta 3", "seinao");
        map.put("Pergunta 4", "pois");

    }

    public static String getRandomQuestion() {
        Random generator = new Random();
        String[] keys = map.keySet().toArray(new String[map.size()]);
        return keys[generator.nextInt(keys.length)];
    }

    public static boolean isCorrect(String pergunta, String resposta) {
        return map.containsKey(pergunta) && map.get(pergunta).equals(resposta);
    }

}
