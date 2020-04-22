/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import sep.seeter.mvc.ClientModel;
import sep.seeter.net.message.SeetsReply;
import sep.seeter.net.message.SeetsReq;

/**
 * The {@code FetchCommand} is a concrete implementation of
 * {@link sep.seeter.mvc.ClientModel}.
 * 
 * {@code FetchCommand} is executed when a user wants to get seet [topic] from
 * the server {@link sep.seeter.server.Server}
 *  
 * @author abdul
 */
public class FetchCommand implements Command {

    private final ClientModel clientModel;

    /**
     *
     * @param clientModel used to access receiver class with all the cohesive 
     * actions that a command can perform.
     */
    public FetchCommand(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    /**
     *
     * @throws IOException If an I/O error occurs
     * @throws ClassNotFoundException Class of serialized object cannot be found
     */
    @Override
    public void execute() throws IOException, ClassNotFoundException {
        clientModel.send(new SeetsReq(clientModel.getRawArgs()[0]));
        SeetsReply rep = (SeetsReply) clientModel.receive();
        System.out.print(clientModel.formatFetched(clientModel.getRawArgs()[0], rep.users, rep.lines));
    }

}
