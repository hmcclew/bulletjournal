package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * Set Maximum Tasks and Events View
 */
public class SetMaximumView extends AbstractView {

  /**
   * Constructor for a set maximum view
   *
   * @param controller the controller for this view
   */
  public SetMaximumView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource(
        "set-max-events-and-tasks.fxml"));
    this.loader.setController(controller);
  }
}
