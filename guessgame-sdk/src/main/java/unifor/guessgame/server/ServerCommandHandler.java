package unifor.guessgame.server;

import unifor.guessgame.message.Message;
import unifor.guessgame.message.ServerMessage;

/**
 * @author Fernando Nogueira
 * @since 11/21/16 1:36 AM
 */
public interface ServerCommandHandler {

    /**
     * Handle received messages through server API
     *
     * @param command
     * @return
     */
    Message handleCommand(ServerMessage command);
}
