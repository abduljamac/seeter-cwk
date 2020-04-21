/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import static org.hamcrest.CoreMatchers.containsString;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sep.seeter.mvc.ClientController;
import sep.seeter.mvc.ClientModel;
import sep.seeter.mvc.ClientView;
import sep.seeter.net.channel.ClientChannel;

/**
 *
 * @author abdul
 */
public class ComposeCommandTest {

    private InputStream in;
    private ClientModel clientModel;
    private final ClientController clientController;

    Locale locale = new Locale("en", "GB");
    ResourceBundle clformatter = ResourceBundle.getBundle("sep.seeter.resources/clformatter", locale);

    public ComposeCommandTest() {
        this.clientModel = new ClientModel(new ClientChannel("localhost", 3000), "test");
        ClientView clientView = new ClientView();
        this.clientController = new ClientController(clientModel, clientView);
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void composeCommandTest() throws IOException {


            String input = "compose test1\n";
            ByteArrayInputStream inputPars = new ByteArrayInputStream(input.getBytes("UTF-8"));
            System.setIn(inputPars);

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            System.setOut(new PrintStream(output, true, "UTF-8"));

            clientController.run();

            String expectedRes = MessageFormat.format(clformatter.getString("DraftingMenuPrompt"), clientModel.formatDrafting(clientModel.getDraftTopic(), clientModel.getDraftLines()));
            String results = output.toString();
            System.out.println("Output in Test: " + results);
//            assertThat(results, containsString(expectedRes));
            assertEquals(results, expectedRes);
      

    }
}
