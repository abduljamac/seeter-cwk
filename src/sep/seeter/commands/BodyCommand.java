/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;

/**
 *
 * @author abdul
 */
public class BodyCommand implements Command {

    private final CommandReceiver command;

    public BodyCommand(CommandReceiver command) {
        this.command = command;
    }

    @Override
    public void execute() throws IOException{
        String body = String.join( " ", command.getRawArgs() );
        command.addDraftLine(body);
    }

}
