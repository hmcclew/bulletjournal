package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class OpenTemplateView extends AbstractView {

  public OpenTemplateView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource(
        "open-template-prompt.fxml"));
    this.loader.setController(controller);
  }
}
