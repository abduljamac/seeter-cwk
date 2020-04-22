/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import sep.seeter.mvc.ClientModel;
import sep.seeter.net.message.TopicsReply;
import sep.seeter.net.message.TopicsReq;

/**
 * The {@code ListCommand} is a concrete implementation of
 * {@link sep.seeter.mvc.ClientModel}.
 * 
 * {@code ListCommand} is executed when a user wants to list all the
 * available seets [topic] stored in the server {@link sep.seeter.server.Server}.
 * 
 * @author abdul
 */
public class ListCommand implements Command {

    private final ClientModel clientModel;

    /**
     *
     * @param clientModel used to access receiver class with all the cohesive 
     * actions that a command can perform.
     */
    public ListCommand(ClientModel clientModel) {
          this.clientModel = clientModel;
    }

    /**
     *
     * @throws IOException If an I/O error occurs
     * @throws ClassNotFoundException Class of serialized object cannot be found
     */
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        clientModel.send(new TopicsReq());
        TopicsReply rep = (TopicsReply) clientModel.receive();
        System.out.print(clientModel.formatList( rep.topics ));
    }

    
}
