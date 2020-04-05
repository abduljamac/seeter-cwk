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
public class ListCommand implements Command {

    private final CommandReceiver command;

    public ListCommand(CommandReceiver command) {
        this.command = command;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
