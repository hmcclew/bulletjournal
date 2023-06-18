package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * Class for an event pop up view in java journal
 */
public class EventPopUpView extends AbstractView {

  /**
   * Constructor for an event pop up view
   *
   * @param controller the controller for this view
   */
  public EventPopUpView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("event-popup.fxml"));
    this.loader.setController(controller);
  }
}
