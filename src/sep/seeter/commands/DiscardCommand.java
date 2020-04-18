/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sep.seeter.net.message.Publish;

/**
 *
 * @author abdul
 */
public class DiscardCommand implements Command {
    
    private final CommandReceiver command;
    private final List<String> emptyDraftLines;

    public DiscardCommand(CommandReceiver command) {
        this.command = command;
        this.emptyDraftLines = new ArrayList<>();
    }
    

    @Override
    public void execute() throws IOException {
        command.setDraftTopic(null);
        command.setDraftLines(emptyDraftLines);
        command.setCommandState(CommandState.MAIN);
    }
   
    
}
