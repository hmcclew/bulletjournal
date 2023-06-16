package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class NewEventView extends AbstractView{
    public NewEventView(Controller controller) {
        this.loader = new FXMLLoader();
        this.loader.setLocation(getClass().getClassLoader().getResource("newEvent.fxml"));
        this.loader.setController(controller);
    }
}
