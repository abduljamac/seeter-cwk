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
 * 
 * List Command Class - This class is executed when a user wants to list all the
 * available seets [topic] stored in the server.
 * 
 * @author abdul
 */
public class ListCommand implements Command {

    private final ClientModel clientModel;

    /**
     *
     * @param clientModel
     */
    public ListCommand(ClientModel clientModel) {
          this.clientModel = clientModel;
    }

    /**
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        clientModel.send(new TopicsReq());
        TopicsReply rep = (TopicsReply) clientModel.receive();
        System.out.print(clientModel.formatList( rep.topics ));
    }

    
}
