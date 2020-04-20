/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 *
 * @author abdul
 */
public final class CommandWords {
    
    Locale locale = new Locale("en", "GB");
    ResourceBundle commands = ResourceBundle.getBundle("sep.seeter.resources/commands", locale);
    private final Map<String, Command> commandHolder = new HashMap<>();

    public CommandWords(CommandReceiver command) {
        commandHolder.put( commands.getString("exit"), new ExitCommand(command) );
        commandHolder.put( commands.getString("compose"), new ComposeCommand(command) );
        commandHolder.put( commands.getString("body"), new BodyCommand(command) );
        commandHolder.put( commands.getString("send"), new SendCommand(command) );
        commandHolder.put( commands.getString("fetch"), new FetchCommand(command) );
        commandHolder.put( commands.getString("discard"), new DiscardCommand(command) );
        commandHolder.put( commands.getString("list"), new ListCommand(command) );
    }


    public Command getCommandHolder(String cmd) {
        return commandHolder.get(cmd);
    }

}
