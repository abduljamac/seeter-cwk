/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

/**
 *
 * @author abdul
 */
public class BodyCommand implements Command {

    private final CommandReceiver command;
    private String body;

    public BodyCommand(CommandReceiver command, String body) {
        this.command = command;
        this.body = body;
    }

    @Override
    public void execute() {
        body = String.join(" ", command.getRawArgs());
        command.addDraftLine(body);
    }

}
