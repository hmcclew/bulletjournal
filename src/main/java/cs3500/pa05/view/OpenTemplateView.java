package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * view class for opening a template
 */
public class OpenTemplateView extends AbstractView {

  /**
   * constructor for an open template view
   *
   * @param controller the associated controller
   */
  public OpenTemplateView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource(
        "open-template-prompt.fxml"));
    this.loader.setController(controller);
  }
}
