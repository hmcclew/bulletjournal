package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class EditTaskView extends AbstractView {

  public EditTaskView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("edit-task.fxml"));
    this.loader.setController(controller);
  }
}
