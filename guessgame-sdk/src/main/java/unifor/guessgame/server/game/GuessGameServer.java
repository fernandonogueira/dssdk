package unifor.guessgame.server.game;

import unifor.guessgame.builder.ServerBuilder;
import unifor.guessgame.server.GenericServer;

import java.io.IOException;

public class GuessGameServer {

    private GenericServer sdk;

    public GuessGameServer() throws IOException {
        init();
    }

    private void init() throws IOException {

        ServerBuilder buidler = new ServerBuilder();
        buidler.setPort(5654);
        buidler.setUdp(false);
        this.sdk = buidler.build();

    }

    public void listen() throws IOException {
        sdk.listen();
    }

    public static void main(String[] args) throws IOException {
        GuessGameServer server = new GuessGameServer();
        server.listen();
    }

}
