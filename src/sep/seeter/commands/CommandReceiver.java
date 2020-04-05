/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

import java.io.IOException;
import java.util.ArrayList;
import sep.seeter.net.channel.ClientChannel;
import sep.seeter.net.message.Message;
import sep.seeter.net.message.SeetsReply;

/**
 *
 * @author abdul
 */
public class CommandReceiver {

    private CommandState commandState;
    private String user;
    private String[] rawArgs;
    private String draftTopic;
    private ArrayList<String> draftLines;
    private final ClientChannel channel;

    public CommandReceiver(ClientChannel channel, String user) {
        this.commandState = commandState;
        this.user = user;
        this.rawArgs = rawArgs;
        this.draftTopic = draftTopic;
        this.draftLines = draftLines;
        this.channel = channel;
    }

    public CommandState getCommandState() {
        return commandState;
    }

    public void setCommandState(CommandState commandState) {
        this.commandState = commandState;
    }
    
    public String getUser() {
        return user;
    }

    public String[] getRawArgs() {
        return rawArgs;
    }

    public void setRawArgs(String[] rawArgs) {
        this.rawArgs = rawArgs;
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

    public void addDraftLine(String line) {
        this.draftLines.add(line);
    }

    public void deleteTask(String line) {
        this.draftLines.remove(line);
    }

    public void showAllTasks() {
        for (String draftLine : draftLines) {
            System.out.println(draftLine);
        }
    }

    public <T extends Message> void sendMsg(T message) throws IOException {
        channel.send(message);
    }

    public SeetsReply receiveMsg() throws IOException, ClassNotFoundException {
        return (SeetsReply) channel.receive();
    }

}
