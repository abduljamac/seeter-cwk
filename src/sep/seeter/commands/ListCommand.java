/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import sep.seeter.client.CLFormatter;
import sep.seeter.net.message.TopicsReply;
import sep.seeter.net.message.TopicsReq;

/**
 *
 * @author abdul
 */
public class ListCommand implements Command {

    private final CommandReceiver command;

    public ListCommand(CommandReceiver command) {
        this.command = command;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        command.send(new TopicsReq());
        TopicsReply rep = (TopicsReply) command.receive();
        System.out.print(CLFormatter.formatList( rep.topics ));
    }

    
}
