package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * Class for the view of editing an event
 */
public class EditEventView extends AbstractView {

  /**
   * constructor for edit event view
   *
   * @param controller the controller used with this view
   */
  public EditEventView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("edit-event.fxml"));
    this.loader.setController(controller);
  }
}
