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
 *
 * @author abdul
 */
public class ClientController extends AbstractController {

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

    public void run() throws IOException {
        getView().run();
    }

    @Override
    public void shutdown() {
        this.getView().close();
    }

    public void updateOutput(String newText) {
        this.getModel().setOutput(newText);
        this.getView().update();
    }
}
