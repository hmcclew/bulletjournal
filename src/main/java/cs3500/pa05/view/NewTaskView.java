package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class NewTaskView extends AbstractView {

    public NewTaskView(Controller controller) {
        this.loader = new FXMLLoader();
        this.loader.setLocation(getClass().getClassLoader().getResource("newTask.fxml"));
        this.loader.setController(controller);
    }
}
