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
 *
 * @author abdul
 */
public final class CommandWords {
    
    Locale locale = new Locale("fr", "FR");
    ResourceBundle commands = ResourceBundle.getBundle("sep.seeter.resources/commands", locale);
    private final Map<String, Command> commandHolder = new HashMap<>();

    public CommandWords(ClientModel clientModel) {
        commandHolder.put( commands.getString("exit"), new ExitCommand(clientModel) );
        commandHolder.put( commands.getString("compose"), new ComposeCommand(clientModel) );
        commandHolder.put( commands.getString("body"), new BodyCommand(clientModel) );
        commandHolder.put( commands.getString("send"), new SendCommand(clientModel) );
        commandHolder.put( commands.getString("fetch"), new FetchCommand(clientModel) );
        commandHolder.put( commands.getString("discard"), new DiscardCommand(clientModel) );
        commandHolder.put( commands.getString("list"), new ListCommand(clientModel) );
    }


    public Command getCommandHolder(String cmd) {
        return commandHolder.get(cmd);
    }

}
