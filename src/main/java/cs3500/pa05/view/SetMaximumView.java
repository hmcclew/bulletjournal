package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class SetMaximumView extends AbstractView {

    public SetMaximumView(Controller controller) {
        this.loader = new FXMLLoader();
        this.loader.setLocation(getClass().getClassLoader().getResource("setMaxEventsTasks.fxml"));
        this.loader.setController(controller);
    }
}
