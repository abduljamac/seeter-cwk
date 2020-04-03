/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.command;

import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class CommandReceiver {
    
    private CommandState commandState;
    private String draftTopic;
    private ArrayList<String> draftLines;

    public CommandReceiver(CommandState commandState, String draftTopic, ArrayList<String> draftLines) {
        this.commandState = commandState;
        this.draftTopic = draftTopic;
        this.draftLines = draftLines;
    }

    public CommandState getCommandState() {
        return commandState;
    }

    public void setCommandState(CommandState commandState) {
        this.commandState = commandState;
    }

    public String getDraftTopic() {
        return draftTopic;
    }

    public void setDraftTopic(String draftTopic) {
        this.draftTopic = draftTopic;
    }

    public ArrayList<String> getDraftLines() {
        return draftLines;
    }

    public void setDraftLines(ArrayList<String> draftLines) {
        this.draftLines = draftLines;
    }
    
    
    
    
    
}
