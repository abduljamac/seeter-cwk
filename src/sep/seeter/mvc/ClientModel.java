/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import sep.mvc.AbstractModel;
import sep.seeter.commands.CommandState;
import sep.seeter.net.channel.ClientChannel;
import sep.seeter.net.message.Bye;
import sep.seeter.net.message.Message;

/**
 *
 * @author abdul
 */
public class ClientModel extends AbstractModel {
    
    private CommandState commandState;
    private String user;
    private String[] rawArgs;
    private String draftTopic;
    private List<String> draftLines;
    private final ClientChannel channel;
    
    Locale locale = new Locale("en", "GB");
    ResourceBundle clformatter = ResourceBundle.getBundle("sep.seeter.resources/clformatter", locale);

    public ClientModel(ClientChannel channel, String user) {
        this.commandState = commandState.MAIN;
        this.user = user;
        this.rawArgs = rawArgs;
        this.draftTopic = draftTopic;
        this.draftLines = new ArrayList<>();
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

    public List<String> getDraftLines() {
        return draftLines;
    }

    public void setDraftLines(List<String> draftLines) {
        this.draftLines = draftLines;
    }

    public void addDraftLine(String line) {
        this.draftLines.add(line);
    }

    public void send(Message msg) throws IOException {
        this.channel.send(msg);
    }

    public Message receive() throws IOException, ClassNotFoundException {
        return this.channel.receive();
    }

    public void closeClient() throws IOException {
        if (channel.isOpen()) {
            channel.send(new Bye());
            channel.close();
        }
    }

    public String formatDrafting(String topic, List<String> lines) {
        StringBuilder b = new StringBuilder("#");
        b.append(topic);
        int i = 1;
        for (String x : lines) {
            b.append("\n");
            b.append(String.format("%12d", i++));
            b.append("  ");
            b.append(x);
        }
        return b.toString();
    }

    public  String formatFetched(String topic, List<String> users,
            List<String> fetched) {
        StringBuilder b = new StringBuilder(clformatter.getString("fetched"));
        b.append(topic);
        Iterator<String> it = fetched.iterator();
        for (String userName : users) {
            b.append("\n");
            b.append(String.format("%12s", userName));
            b.append("  ");
            b.append(it.next());
        }
        b.append("\n");
        return b.toString();
    }

    public String formatList(Set<String> fetched) {
        StringBuilder b = new StringBuilder(clformatter.getString("topics"));
        b.append(fetched);
        b.append("\n");
        return b.toString();
    }


    
}
