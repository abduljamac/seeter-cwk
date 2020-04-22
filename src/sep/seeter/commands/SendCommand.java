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
 * The {@code SendCommand} is a concrete implementation of
 * {@link sep.seeter.mvc.ClientModel}.
 * 
 * {@code SendCommand} is executed when a user is finished drafting 
 * a seet [topic] and seet line and want to send it of to the server 
 * {@link sep.seeter.server.Server}.
 * 
 * {@code SendCommand} once a seet [topic] is sent it sets the state of the 
 * application is set to MAIN returning the user to the main menu prompt
 * allowing them to create more seets.
 * 
 * @author abdul
 */
public class SendCommand implements Command {
    
    private List<String> clearDraftLines;
    private final ClientModel clientModel;
    
    /**
     *
     * @param clientModel used to access receiver class with all the cohesive 
     * actions that a command can perform.
     */
    public SendCommand(ClientModel clientModel) {
        this.clientModel = clientModel;
        this.clearDraftLines = new ArrayList<>();
    }
    
    /**
     * 
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void execute() throws IOException {
        clientModel.send(new Publish( clientModel.getUser(), clientModel.getDraftTopic(), clientModel.getDraftLines() ));
        clientModel.setCommandState(CommandState.MAIN);
        clientModel.setDraftTopic(null);
        clientModel.setDraftLines(clearDraftLines);
    }
    
}
