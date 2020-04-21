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
 * Send Command Class - This class is executed when a user is finished drafting 
 * a seet [topic] and seet line and want to send it of tot he server.
 *
 * @author abdul
 */
public class SendCommand implements Command {
    
    private List<String> clearDraftLines;
    private final ClientModel clientModel;
    
    /**
     *
     * @param clientModel
     */
    public SendCommand(ClientModel clientModel) {
        this.clientModel = clientModel;
        this.clearDraftLines = new ArrayList<>();
    }
    
    /**
     * 
     * @throws IOException
     */
    @Override
    public void execute() throws IOException {
        clientModel.send(new Publish( clientModel.getUser(), clientModel.getDraftTopic(), clientModel.getDraftLines() ));
        clientModel.setCommandState(CommandState.MAIN);
        clientModel.setDraftTopic(null);
        clientModel.setDraftLines(clearDraftLines);
    }
    
}
