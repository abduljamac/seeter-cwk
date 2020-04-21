/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.commands;

/**
 * Enumeration class CommandState - This ENUM class declares the 
 * different states available to the Seeter command line app.
 *
 * @author abdul
 */
public enum CommandState {
    
    MAIN("Main"), DRAFTING("Drafting"), TERMINATED("Terminated");
    
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
