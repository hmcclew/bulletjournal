package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;


/**
 * View class for creating a new task
 */
public class NewTaskView extends AbstractView {

  /**
   * Constructor for a new task view
   *
   * @param controller the controller for this view
   */
  public NewTaskView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("newTask.fxml"));
    this.loader.setController(controller);
  }
}
