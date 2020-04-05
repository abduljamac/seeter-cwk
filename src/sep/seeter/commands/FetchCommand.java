/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import sep.seeter.client.CLFormatter;
import sep.seeter.net.message.SeetsReply;
import sep.seeter.net.message.SeetsReq;

/**
 *
 * @author abdul
 */
public class FetchCommand implements Command {

    private final CommandReceiver command;

    public FetchCommand(CommandReceiver command) {
        this.command = command;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        command.send(new SeetsReq( command.getRawArgs()[0] ));
        SeetsReply rep = (SeetsReply) command.receive();
        System.out.print(CLFormatter.formatFetched( command.getRawArgs()[0], rep.users, rep.lines ));
    }
    
    
}
