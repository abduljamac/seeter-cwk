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
 * The {@code ComposeCommand} is a concrete implementation of
 * {@link sep.seeter.mvc.ClientModel}.
 * 
 * {@code ComposeCommand} is executed when a user wants to create 
 * a brand new seet for a topic. In addition,{@code ComposeCommand} switches
 * the state of the application from MAIN to DRAFTING.
 *
 * @author abdul
 */
public class ComposeCommand implements Command {

    private final ClientModel clientModel;
    
    /**
     *
     * @param clientModel used to access receiver class with all the cohesive 
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