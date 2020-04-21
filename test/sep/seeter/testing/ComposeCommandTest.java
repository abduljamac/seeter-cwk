package sep.seeter.testing;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sep.seeter.commands.CommandState;
import sep.seeter.commands.ComposeCommand;
import sep.seeter.mvc.ClientModel;
import sep.seeter.net.channel.ClientChannel;

/**
 *
 * @author abdul
 */
public class ComposeCommandTest {

    private ClientModel clientModel;
    private ComposeCommand composeCommand;
    
    Locale locale = new Locale("en", "GB");
    ResourceBundle clformatter = ResourceBundle.getBundle("sep.seeter.resources/clformatter", locale);

    public ComposeCommandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        clientModel = new ClientModel(new ClientChannel("localhost", 3000), "Body Test");
    }

    @After
    public void tearDown() throws IOException {
        clientModel.closeClient();
    }

    @Test
    public void composeCommandTestValid() throws IOException {
        
        String[] topic = {"topic1"};

        clientModel.setRawArgs(topic);

        composeCommand.execute();

        assertEquals(CommandState.DRAFTING, clientModel.getCommandState());
        assertEquals(topic[0], clientModel.getDraftTopic());


    }
    
     @Test
    public void composeCommandTestInValid() throws IOException {
        
        String[] topic = {"_."};

        clientModel.setRawArgs(topic);

        composeCommand.execute();

        assertEquals( clformatter.getString("CommandError"), clientModel.getRawArgs()[0], clientModel.getOutput() );



    }
}
