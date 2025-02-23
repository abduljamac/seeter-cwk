/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sep.seeter.mvc.ClientModel;
import sep.seeter.net.message.Publish;

/**
 * The {@code DiscardCommand} is a concrete implementation of
 * {@link sep.seeter.mvc.ClientModel}.
 * 
 * {@code DiscardCommand} is executed when a user no longer wants to
 * send of drafted seet [topic] with seet line, it deleted drafted seet and 
 * returns user back to the Main Prompt.
 * 
 * Sets the draftTopic to null and draftLines to empty array in {@code ClientModel}
 *
 * @author abdul
 */
public class DiscardCommand implements Command {

    private final ClientModel clientModel;
    private final List<String> emptyDraftLines;

    /**
     *
     * @param clientModel used to access receiver class with all the cohesive 
     * actions that a command can perform.
     */
    public DiscardCommand(ClientModel clientModel) {
        this.clientModel = clientModel;
        this.emptyDraftLines = new ArrayList<>();
    }

    /**
     *
     * @throws IOException If an I/O error occurs
     */
    @Override
    public void execute() throws IOException {
        clientModel.setDraftTopic(null);
        clientModel.setDraftLines(emptyDraftLines);
        clientModel.setCommandState(CommandState.MAIN);
    }

}
