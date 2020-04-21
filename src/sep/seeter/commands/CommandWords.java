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
import sep.seeter.mvc.ClientModel;

/**
 * CommandWords Class - This class controls which command is executed depending on
 * what the user types into the command, it stores each command in HashMap which has
 * key value pairs that can be used to access a command.
 * @author abdul
 */
public final class CommandWords {
    
    Locale locale = new Locale("en", "GB");
    ResourceBundle commands = ResourceBundle.getBundle("sep.seeter.resources/commands", locale);
    private final Map<String, Command> commandHolder = new HashMap<>();
   
    /**
     *
     * @param clientModel
     */
    public CommandWords(ClientModel clientModel) {
        commandHolder.put( commands.getString("exit"), new ExitCommand(clientModel) );
        commandHolder.put( commands.getString("compose"), new ComposeCommand(clientModel) );
        commandHolder.put( commands.getString("body"), new BodyCommand(clientModel) );
        commandHolder.put( commands.getString("send"), new SendCommand(clientModel) );
        commandHolder.put( commands.getString("fetch"), new FetchCommand(clientModel) );
        commandHolder.put( commands.getString("discard"), new DiscardCommand(clientModel) );
        commandHolder.put( commands.getString("list"), new ListCommand(clientModel) );
    }

    /**
     *
     * @param cmd
     * @return
     */
    public Command getCommandHolder(String cmd) {
        return commandHolder.get(cmd);
    }

}
