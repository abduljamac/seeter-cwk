/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sep.seeter.commands.CommandState;
import sep.seeter.commands.ExitCommand;
import sep.seeter.mvc.ClientModel;
import sep.seeter.net.channel.ClientChannel;

/**
 *
 * @author abdul
 */
public class ExitCommandTest {

    private static ClientModel clientModel;
    private static ExitCommand exitCommand;

    public ExitCommandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ClientChannel channel = new ClientChannel("localhost", 3000);
        clientModel = new ClientModel(channel, "test");
        exitCommand = new ExitCommand(clientModel);
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void exitCommandTest() throws IOException {

        try {
            if (CommandState.MAIN.equals(clientModel.getCommandState())) {
                exitCommand.execute();
                assertEquals(CommandState.TERMINATED, clientModel.getCommandState());
            }
        } catch (Exception ex) {
            System.out.println("Exit Command Not Functioning!" + ex);
        }

    }
}
