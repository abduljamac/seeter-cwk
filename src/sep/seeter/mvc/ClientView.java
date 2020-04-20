/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import sep.mvc.AbstractView;
import sep.seeter.commands.Command;
import sep.seeter.commands.CommandState;
import sep.seeter.commands.CommandWords;

/**
 *
 * @author abdul
 */
public class ClientView extends AbstractView {
    
    Locale locale = new Locale("en", "EN");
    ResourceBundle clformatter = ResourceBundle.getBundle("sep.seeter.resources/clformatter-en", locale);

    @Override
    protected ClientController getController() {
        return (ClientController) super.getController();
    }

    @Override
    protected ClientModel getModel() {
        return (ClientModel) super.getModel();
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            ClientModel clientModel = this.getController().getModel();
            System.out.print(MessageFormat.format(clformatter.getString("Splash"), clientModel.getUser()));
            runCommandLoop(reader, clientModel);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        } finally {
            this.getController().shutdown();
        }
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    private void runCommandLoop(BufferedReader reader, ClientModel clientModel) throws IOException,
            ClassNotFoundException {
        
        while (!CommandState.TERMINATED.equals(clientModel.getCommandState())) {

            if (CommandState.MAIN.equals(clientModel.getCommandState())) {
                System.out.print(clformatter.getString("MainMenuPrompt"));
            } else {
                  System.out.print(MessageFormat.format(clformatter.getString("DraftingMenuPrompt"),  clientModel.formatDrafting(clientModel.getDraftTopic(), clientModel.getDraftLines()) ));
            }

            String raw = reader.readLine();
            if (raw == null) {
                throw new IOException("Input stream closed while reading.");
            }

            // Trim leading/trailing white space, and split words according to spaces
            List<String> split = Arrays.stream(raw.trim().split("\\ ")).map(x -> x.trim()).collect(Collectors.toList());
            String cmd = split.remove(0);  // First word is the command keyword
            String[] rawArgs = split.toArray(new String[split.size()]);

            clientModel.setRawArgs(rawArgs);
     
            Command command = new CommandWords(clientModel).getCommandHolder(cmd);
            command.execute();
            
        }
    }

}
