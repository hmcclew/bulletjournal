package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * view for creating a new event
 */
public class NewEventView extends AbstractView {

  /**
   * constructor for creating a new event view
   *
   * @param controller the controller for this view
   */
  public NewEventView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("new-event.fxml"));
    this.loader.setController(controller);
  }
}
