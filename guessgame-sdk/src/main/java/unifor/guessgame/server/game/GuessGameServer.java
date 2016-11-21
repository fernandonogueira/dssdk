package unifor.guessgame.server.game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import unifor.guessgame.GuessGameDatabase;
import unifor.guessgame.builder.ServerBuilder;
import unifor.guessgame.message.Message;
import unifor.guessgame.message.ServerMessage;
import unifor.guessgame.server.GenericServer;
import unifor.guessgame.server.ServerCommandHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GuessGameServer implements ServerCommandHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GuessGameServer.class);

    private GenericServer sdk;
    private final Object currentQuestionLock = new Object();
    private String currentQuestion;

    private Map<String, Long> scoreMap = new HashMap<>();

    public GuessGameServer() throws IOException {
        init();
    }

    private void init() throws IOException {

        ServerBuilder buidler = new ServerBuilder();
        buidler.setPort(5654);
        buidler.setUdp(false);
        buidler.setServerCommandHandler(this);
        this.sdk = buidler.build();

    }

    public void listen() throws IOException {
        sdk.listen();
    }

    public static void main(String[] args) throws IOException {
        GuessGameServer server = new GuessGameServer();
        server.listen();
    }

    @Override
    public Message handleCommand(ServerMessage command) {

        switch (command.getMethod()) {
            case "suggestWord":
                suggestWord(command);
                break;
            case "joinRoom":
                joinRoom(command);
                break;
        }

        return null;
    }

    public void joinRoom(ServerMessage command) {

        synchronized (currentQuestionLock) {
            if (currentQuestion == null) {
                currentQuestion = GuessGameDatabase.getRandomQuestion();
                LOGGER.info("No room was active. Creating room with question: {}", currentQuestion);

            }
        }
        LOGGER.info("Player {} joined the game.", command.getClientId());
    }

    public void suggestWord(ServerMessage command) {
        LOGGER.info("Player [{}] suggested word command received: [{}]",
                command.getClientId(),
                command);
        // handle suggest word
    }

}
