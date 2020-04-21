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
public enum CommandState {
    
    /**
     *
     */
    MAIN("Main"),

    /**
     *
     */
    DRAFTING("Drafting"),

    /**
     *
     */
    TERMINATED("Terminated");
    
    private String state;
    
    private CommandState(String st)
    {
        state = st;
    }
    
    public String toString()
    {
        return state;
    }
    
}
