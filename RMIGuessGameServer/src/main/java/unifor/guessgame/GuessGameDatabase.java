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

        map.put("Apresentadora de TV famosa entre crianças", "xuxa");
        map.put("Patriarca da família Simpson", "homer");
        map.put("Editora de quadrinhos responsável pelos X-Men", "marvel");
        map.put("Planta cujo fruto é a uva", "videira");
        map.put("Rede social famosa", "facebook");
        map.put("Alimento que consiste em um disco de massa", "pizza");
        map.put("Mamífero marsupial nativo da Austrália", "canguru");

    }

    public static String getRandomQuestion() {
        Random generator = new Random();
        String[] keys = map.keySet().toArray(new String[map.size()]);
        return keys[generator.nextInt(keys.length)];
    }

    public static boolean isCorrect(String pergunta, String resposta) {
        return map.containsKey(pergunta) && map.get(pergunta).equalsIgnoreCase(resposta);
    }

}
