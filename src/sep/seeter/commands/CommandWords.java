/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author abdul
 */
public class CommandWords {

    private final Map<String, Command> commandHolder = new HashMap<>();
    private final CommandReceiver command;

    public CommandWords(CommandReceiver command) {
        this.command = command;
        populateCommandController(command);
    }

    public void populateCommandController(CommandReceiver command) {
        commandHolder.put("exit", new ExitCommand(command));
        commandHolder.put("compose", new ComposeCommand(command));
        commandHolder.put("body", new BodyCommand(command));
    }

    public Command getCommandHolder(String cmd) {
        return commandHolder.get(cmd);
    }

}
