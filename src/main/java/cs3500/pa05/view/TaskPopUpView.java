package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * Task Pop Up Mini Viewer View
 */
public class TaskPopUpView extends AbstractView {

  /**
   * Constructor for task pop up view
   *
   * @param controller the controller for this view
   */
  public TaskPopUpView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("taskPopUp.fxml"));
    this.loader.setController(controller);
  }
}
