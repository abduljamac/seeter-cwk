/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sep.seeter.mvc;

import java.io.IOException;
import sep.mvc.AbstractController;
import sep.mvc.AbstractModel;
import sep.mvc.AbstractView;
import sep.seeter.commands.CommandWords;

/**
 * The {@code ClientController} is the main controller for the Client. It task
 * is to deal with all the commands and the connection between the view and model.
 * 
 * @author abdul
 */
public class ClientController extends AbstractController {

    /**
     *
     * @param model application core data structure.
     * @param view appropriate representation of the relevant model data to the user.
     */
    public ClientController(AbstractModel model, AbstractView view) {
        super(model, view);
    }

    @Override
    public ClientModel getModel() {
        return (ClientModel) super.getModel();
    }

    @Override
    public ClientView getView() {
        return (ClientView) super.getView();
    }

    /**
     *
     * @throws IOException If an I/O error occurs
     */
    public void run() throws IOException {
        getView().run();
    }

    @Override
    public void shutdown() {
        this.getView().close();
    }
}
