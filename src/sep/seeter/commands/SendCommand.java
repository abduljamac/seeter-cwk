/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sep.seeter.mvc.ClientModel;
import sep.seeter.net.message.Publish;


/**
 *
 * @author abdul
 */
public class SendCommand implements Command {
    
//    private final CommandReceiver command;
    private List<String> clearDraftLines;
    private final ClientModel clientModel;
    

    public SendCommand(ClientModel clientModel) {
//        this.command = command;
        this.clientModel = clientModel;
        this.clearDraftLines = new ArrayList<>();
    }
    

    @Override
    public void execute() throws IOException {
        clientModel.send(new Publish( clientModel.getUser(), clientModel.getDraftTopic(), clientModel.getDraftLines() ));
        clientModel.setCommandState(CommandState.MAIN);
        clientModel.setDraftTopic(null);
        clientModel.setDraftLines(clearDraftLines);
    }
    
}
