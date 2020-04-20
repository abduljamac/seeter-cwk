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
 * @author abdul
 */
public class ListCommand implements Command {

//    private final CommandReceiver command;
    private final ClientModel clientModel;

    public ListCommand(ClientModel clientModel) {
//        this.command = command;
          this.clientModel = clientModel;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        clientModel.send(new TopicsReq());
        TopicsReply rep = (TopicsReply) clientModel.receive();
        System.out.print(clientModel.formatList( rep.topics ));
    }

    
}
