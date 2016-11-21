package unifor.guessgame.client.game;

import com.google.common.collect.Lists;
import unifor.guessgame.builder.ClientBuilder;
import unifor.guessgame.client.tcp.GenericTCPClient;
import unifor.guessgame.message.Message;
import unifor.guessgame.message.Param;

public class GuessGameClient {

    private GenericTCPClient sdk;

    public GuessGameClient() {
        init();
    }

    private void init() {
        ClientBuilder builder = new ClientBuilder();
        builder.setServerHost("localhost");
        builder.setServerPort(5654);
        this.sdk = builder.build();
    }

    public void suggestWord(String word) {
        Message msg = new Message();
        msg.setMethod("suggestWord");

        Param param = new Param();
        param.setName("word");
        param.setValue(word);
        msg.setParams(Lists.newArrayList(param));

        sdk.sendMessage(msg);
    }

    public static void main(String[] args) {
        GuessGameClient client = new GuessGameClient();
        client.joinRoom();
        client.suggestWord("azeitona");
        client.suggestWord("andre_baitola");
        client.suggestWord("sei la");
    }

    private void joinRoom() {
        Message msg = new Message();
        msg.setMethod("joinRoom");
        sdk.sendMessage(msg);
    }

}
