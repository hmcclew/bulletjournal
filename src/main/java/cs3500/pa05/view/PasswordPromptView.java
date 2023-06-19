package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * View for a password prompt
 */
public class PasswordPromptView extends AbstractView {

  /**
   * Constructor for a password prompt
   *
   * @param controller the controller for this view
   */
  public PasswordPromptView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource(
        "password-prompt.fxml"));
    this.loader.setController(controller);
  }
}
