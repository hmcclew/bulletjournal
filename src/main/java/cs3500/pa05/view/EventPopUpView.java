package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class EventPopUpView extends AbstractView {

    public EventPopUpView(Controller controller) {
        this.loader = new FXMLLoader();
        this.loader.setLocation(getClass().getClassLoader().getResource("eventPopUp.fxml"));
        this.loader.setController(controller);
    }
}
