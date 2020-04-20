/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import sep.seeter.mvc.ClientModel;

/**
 *
 * @author abdul
 */
public class ExitCommand implements Command {

//    private final CommandReceiver command;
    private final ClientModel clientModel;

    public ExitCommand(ClientModel clientModel) {
//        this.command = command;
        this.clientModel = clientModel;
    }

    @Override
    public void execute() throws IOException {
        clientModel.setCommandState(CommandState.TERMINATED);
    }

}
