/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import sep.seeter.mvc.ClientModel;

/**
 * Body Command Class - This class in executed when a user wants to add a new draft
 * line to a topic.
 * @author abdul
 */
public class BodyCommand implements Command {

    private final ClientModel clientModel;

    /**
     *
     * @param clientModel used to access reciever class with all the cohesive 
     * actions that a command can perform.
     */
    public BodyCommand(ClientModel clientModel) {
          this.clientModel = clientModel;
    }

    /**
     * String body now contains user input.
     *
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void execute() throws IOException{
        String body = String.join( " ", clientModel.getRawArgs() );
        clientModel.addDraftLine(body);
    }

}
