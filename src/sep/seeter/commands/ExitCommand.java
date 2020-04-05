/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

/**
 *
 * @author abdul
 */
public class ExitCommand implements Command {
   
    private final CommandReceiver command;

    public ExitCommand(CommandReceiver command) {
        this.command = command;
    }
   
    @Override
    public void execute() {
        command.setCommandState(CommandState.TERMINATED);
    }
    
}
