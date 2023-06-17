package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * View for creating a new category
 */
public class CreateCategoryView extends AbstractView {

  /**
   * Constructor for a create category view
   *
   * @param controller the controller for this view
   */
  public CreateCategoryView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("newCategory.fxml"));
    this.loader.setController(controller);
  }
}
