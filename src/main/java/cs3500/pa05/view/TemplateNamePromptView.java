package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * class for naming a template file view
 */
public class TemplateNamePromptView extends AbstractView {

  /**
   * constructor for a template name prompt view
   *
   * @param controller the associated controller
   */
  public TemplateNamePromptView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("template-name-prompt.fxml"));
    this.loader.setController(controller);
  }
}
