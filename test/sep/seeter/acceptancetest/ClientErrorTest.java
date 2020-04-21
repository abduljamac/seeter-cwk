/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.acceptancetest;

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
public class ClientErrorTest {
    

    private InputStream in;
    private Client client;

      public ClientErrorTest() {
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

      
    @Test(expected = Exception.class)
    public void clientIncorrectCommandTest() throws Exception {
        String input = "bettlejuice\n"; 
        ByteArrayInputStream byteIn = new ByteArrayInputStream(input.getBytes("UTF-8")); 
        System.setIn(byteIn);
        client = new Client("test", "localhost",  3000);
        client.runClient();
    }

    @Test(expected = Exception.class)
    public void testClientSetup() throws Exception {
        String input = "fetch A\n";
        ByteArrayInputStream byteIn = new ByteArrayInputStream(input.getBytes("UTF-8"));
        System.setIn(byteIn);
        client = new Client("", "", 3);
        client.runClient();
    }
    @Test(expected = Exception.class)
    public void checkClientPort() throws Exception {
        String input = "fetch A\n";
        ByteArrayInputStream byteIn = new ByteArrayInputStream(input.getBytes("UTF-8"));
        System.setIn(byteIn);
        client = new Client("Jogn", "localhost", -2);
        client.runClient();
    }
}
