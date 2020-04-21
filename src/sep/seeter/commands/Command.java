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
     * A base interface for every command (Initial Blueprint)
     * @throws IOException  If an I/O error occurs
     * @throws ClassNotFoundException Class of serialized object cannot be found
     */
    void execute() throws IOException, ClassNotFoundException;

}
