/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import java.util.List;
import sep.seeter.mvc.ClientModel;

/**
 * Compose Command Class - This class in executed when a user wants to create a 
 * brand new topic.
 * @author abdul
 */
public class ComposeCommand implements Command {

    private final ClientModel clientModel;
    
    /**
     *
     * @param clientModel used to access reciever class with all the cohesive 
     * actions that a command can perform.
     */
    public ComposeCommand(ClientModel clientModel) {
           this.clientModel = clientModel;
    }

    /**
     *
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void execute() throws IOException {
      clientModel.setCommandState(CommandState.DRAFTING);
      clientModel.setDraftTopic(clientModel.getRawArgs()[0]);
    }
    
}