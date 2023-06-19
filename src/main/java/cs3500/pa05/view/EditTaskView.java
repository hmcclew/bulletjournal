package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * Class for the view of editing an task
 */
public class EditTaskView extends AbstractView {

  /**
   * constructor for edittaskview
   *
   * @param controller the controller used with this view
   */
  public EditTaskView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("edit-task.fxml"));
    this.loader.setController(controller);
  }
}
