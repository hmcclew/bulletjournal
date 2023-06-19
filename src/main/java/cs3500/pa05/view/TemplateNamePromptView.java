package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class TemplateNamePromptView extends AbstractView {

  public TemplateNamePromptView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("template-name-prompt.fxml"));
    this.loader.setController(controller);
  }
}
