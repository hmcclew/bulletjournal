package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * View class for searching for a task
 */
public class TaskSearchView extends AbstractView {

  /**
   * constructor for a task search view
   *
   * @param controller the controller for the scene
   */
  public TaskSearchView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("task-search.fxml"));
    this.loader.setController(controller);
  }
}
