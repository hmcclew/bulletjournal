package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * View for a welcome view splash screen
 */
public class WelcomeView extends AbstractView {

  /**
   * constructor for welcome view
   *
   * @param controller the controller used with this view
   */
  public WelcomeView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("welcome.fxml"));
    this.loader.setController(controller);
  }
}
