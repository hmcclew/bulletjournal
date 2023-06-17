package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class CreateCategoryView extends AbstractView {
  public CreateCategoryView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("newCategory.fxml"));
    this.loader.setController(controller);
  }
}
