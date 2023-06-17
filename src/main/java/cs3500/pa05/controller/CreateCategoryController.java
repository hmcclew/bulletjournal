package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller for creating a new category
 */
public class CreateCategoryController implements Controller {
  @FXML
  private Button finish;
  @FXML
  private TextField categoryName;
  private Stage stage;
  private Week week;
  private String category;

  /**
   * Constructor for a new category controller
   *
   * @param stage the stage for the popup
   * @param week the week the category will be added to
   */
  public CreateCategoryController(Stage stage, Week week) {
    this.stage = stage;
    this.week = week;
  }

  /**
   * runs the controller
   *
   * @throws IllegalStateException if an exception is encountered
   */
  @Override
  public void run() throws IllegalStateException {
    initFinishButton();
  }

  /**
   * initializes the finish button
   */
  private void initFinishButton() {
    finish.setOnAction(event -> {
      if (categoryName.getText() != "") {
        category = categoryName.getText();
        week.addCategory(category);
      }
      stage.close();
    });
  }
}
