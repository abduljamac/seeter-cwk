package sep.seeter.commands;

import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abdul
 */
public interface Command {

    /**
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public abstract void execute() throws IOException, ClassNotFoundException;

}
