/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.acceptance;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sep.seeter.client.Client;

/**
 *
 * @author abdul
 */
public class ClientSuccessTest {

    private InputStream in;
    private Client client;

    public ClientSuccessTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        in = System.in;
    }

    @After
    public void tearDown() {
        System.setIn(in);
    }

    @Test
    public void testSingleExitCommand() throws Exception {
        String input = "exit\n";
        ByteArrayInputStream byteIn = new ByteArrayInputStream(input.getBytes("UTF-8"));
        System.setIn(byteIn);
        client = new Client("test", "localhost", 3000);
        client.runClient();
    }

    @Test
    public void testChainedCommands_full_successful() throws Exception {
        String input = "compose B\n body test test\n body test\n send\n fetch B\n exit\n";
        ByteArrayInputStream byteIn = new ByteArrayInputStream(input.getBytes("UTF-8"));
        System.setIn(byteIn);
        client = new Client("test", "localhost", 3000);
        client.runClient();
    }
    
}
