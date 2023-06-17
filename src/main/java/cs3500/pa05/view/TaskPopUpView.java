package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class TaskPopUpView extends AbstractView {

    public TaskPopUpView(Controller controller) {
        this.loader = new FXMLLoader();
        this.loader.setLocation(getClass().getClassLoader().getResource("taskPopUp.fxml"));
        this.loader.setController(controller);
    }
}
