/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import sep.seeter.mvc.ClientModel;

/**
 *
 * @author abdul
 */
public class ComposeCommand implements Command {

    private final ClientModel clientModel;
    
    Locale locale = new Locale("en", "GB");
    ResourceBundle clformatter = ResourceBundle.getBundle("sep.seeter.resources/clformatter", locale);

    public ComposeCommand(ClientModel clientModel) {
           this.clientModel = clientModel;
    }

    @Override
    public void execute() throws IOException {
      clientModel.setOutput(MessageFormat.format( clformatter.getString("ComposeError"), clientModel.getRawArgs()[0] ) );
      clientModel.setCommandState(CommandState.DRAFTING);
      clientModel.setDraftTopic(clientModel.getRawArgs()[0]);
    }
    
}
