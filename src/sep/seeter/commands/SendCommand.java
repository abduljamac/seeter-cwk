/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import sep.seeter.net.message.Publish;


/**
 *
 * @author abdul
 */
public class SendCommand implements Command {
    
    private final CommandReceiver command;

    public SendCommand(CommandReceiver command) {
        this.command = command;
    }
    

    @Override
    public void execute() throws IOException {
        command.send(new Publish(command.getUser(), command.getDraftTopic(), command.getDraftLines()));
        command.setCommandState(CommandState.MAIN);
        command.setDraftTopic(null);
    }
    
}
