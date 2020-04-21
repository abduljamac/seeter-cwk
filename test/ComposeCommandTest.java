/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
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
    
    private static ClientModel clientModel;
    private static ComposeCommand composeCommand;
    
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
        ClientChannel channel = new ClientChannel("localhost", 3000);
        clientModel = new ClientModel(channel, "test");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
   @Test
    public void composeCommandTest() throws IOException {

 

    }
}
