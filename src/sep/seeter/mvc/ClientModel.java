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
 * The {@code ClientModel} as it acts as the receiver class and holds all the
 * actions required by the concrete command classes {@link sep.seeter.commands} 
 *
 * @author abdul
 */
public class ClientModel extends AbstractModel {

    private CommandState commandState;
    private final String user;
    private String[] rawArgs;
    private String draftTopic;
    private List<String> draftLines;
    private final ClientChannel channel;

    Locale locale = new Locale("en", "GB");
    ResourceBundle clformatter = ResourceBundle.getBundle("sep.seeter.resources/clformatter", locale);

    /**
     * Allocated a new ClientModel object once seeter application is run.
     *
     * @param channel The server host and port, <i>e.g.</i>,
     * {@code "localhost", 3000}
     * @param user Current application user, <i>e.g.</i>, {@code "John"}
     */
    public ClientModel(ClientChannel channel, String user) {
        this.commandState = CommandState.MAIN;
        this.user = user;
        this.draftTopic = null;
        this.draftLines = new ArrayList<>();
        this.channel = channel;
    }

    /**
     * Returns current state of the application.
     *
     * @return what's the state the application
     */
    public CommandState getCommandState() {
        return commandState;
    }

    /**
     * Sets the desired state of the application.
     *
     * @param commandState either Main, Drafting or Terminated
     */
    public void setCommandState(CommandState commandState) {
        this.commandState = commandState;
    }

    /**
     * Returns current user.
     *
     * @return name of the user
     */
    public String getUser() {
        return user;
    }

    /**
     * Returns what the user has inputed in the command line.
     *
     * @return user input in the command line
     */
    public String[] getRawArgs() {
        return rawArgs;
    }

    /**
     * Sets rawArgs to what the user has inputed in the command line.
     *
     * @param newRawArgs user input
     */
    public void setRawArgs(String[] newRawArgs) {
        this.rawArgs = newRawArgs;
    }

    /**
     * Returns the the name of the composed topic.
     *
     * @return name of the topic
     */
    public String getDraftTopic() {
        return draftTopic;
    }

    /**
     * Sets the name of the composed topic.
     *
     * @param draftTopic new seet name for [topic]
     */
    public void setDraftTopic(String draftTopic) {
        this.draftTopic = draftTopic;
    }

    /**
     * Returns all the seet lines a topic has.
     *
     * @return array of all the seet lines for topic
     */
    public List<String> getDraftLines() {
        return draftLines;
    }

    /**
     * Sets the seet line for a topic.
     *
     * @param draftLines new seet line for [topic]
     */
    public void setDraftLines(List<String> draftLines) {
        this.draftLines = draftLines;
    }

    /**
     * Adds all the seet lines user has entered into an array.
     *
     * @param line add new seet line to current draft
     */
    public void addDraftLine(String line) {
        this.draftLines.add(line);
    }

    /**
     * Used to send the new drafted seet [topic] to the server.
     *
     * @param msg The message to send
     * @throws IOException If an I/O error occurs
     */
    public void send(Message msg) throws IOException {
        this.channel.send(msg);
    }

    /**
     * Used to retrieve all the available seets [topics] stored in the server.
     *
     * @return The received message from the server, if successful.
     * @throws IOException If an I/O error occurs
     * @throws ClassNotFoundException Class of serialized object cannot be found
     */
    public Message receive() throws IOException, ClassNotFoundException {
        return this.channel.receive();
    }

    /**
     * Used to close the seeter application once user exits.
     *
     * @throws IOException If an I/O error occurs
     */
    public void closeClient() throws IOException {
        if (channel.isOpen()) {
            channel.send(new Bye());
            channel.close();
        }
    }

    /**
     * Once a user composes a topic this method is called to display what the
     * current topics name is and all available seet line drafts.
     *
     * @param topic name of the topic
     * @param lines array of all the seet lines for topic.
     * @return Topic name and drafted seet line (<i>i.e.</i>, { Drafting:
     * #topic1 1 hello world } )
     */
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

    /**
     * Once a user choose which seet [topic] they want to retrieve from the
     * server this method is called to display that seet in readable manor.
     *
     * @param topic name of the topic
     * @param users name of the user that submited the seet [topic]
     * @param fetched string "Fetched: #"
     * @return Topic name, seet list and author name (<i>i.e.</i>, { Fetched:
     * #topic1 john hello world } )
     */
    public String formatFetched(String topic, List<String> users,
            List<String> fetched) {
        StringBuilder b = new StringBuilder(clformatter.getString("Fetched"));
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

    /**
     * When a user decides to list all available seet [topic] this method is
     * used to put all available topics into array and display them.
     *
     * @param fetched string "List of Topics: "
     * @return Array that holds all the seets retrieved from the server.
     * (<i>i.e.</i>, { List of Topics: [topic1] } )
     */
    public String formatList(Set<String> fetched) {
        StringBuilder b = new StringBuilder(clformatter.getString("Topics"));
        b.append(fetched);
        b.append("\n");
        return b.toString();
    }

}
