package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * Abstract class for a controller to create a new assignment
 */
public abstract class AbstractNewAssignmentController {
  @FXML
  protected RadioButton monday;
  @FXML
  protected RadioButton tuesday;
  @FXML
  protected RadioButton wednesday;
  @FXML
  protected RadioButton thursday;
  @FXML
  protected RadioButton friday;
  @FXML
  protected RadioButton saturday;
  @FXML
  protected RadioButton sunday;
  @FXML
  protected ChoiceBox<String> categoryChoices;
  protected String category;

  protected String day;

  protected Week week;

  /**
   * initializes all the category options shown in the popup
   */
  public void initCategories() {
    for (String category : week.getCategories()) {
      categoryChoices.getItems().add(category);
    }
    categoryChoices.setDisable(false);
  }

  /**
   * initializes all radio buttons so only one can be pressed at a time
   */
  public void initRadioButtons() {
    ToggleGroup toggleGroup = new ToggleGroup();
    monday.setToggleGroup(toggleGroup);
    tuesday.setToggleGroup(toggleGroup);
    wednesday.setToggleGroup(toggleGroup);
    thursday.setToggleGroup(toggleGroup);
    friday.setToggleGroup(toggleGroup);
    saturday.setToggleGroup(toggleGroup);
    sunday.setToggleGroup(toggleGroup);

    toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue != null) {
        RadioButton selectedRadioButton = (RadioButton) newValue;
        day = selectedRadioButton.getText();
      }
    });
  }

  /**
   * determines which category the user has selected
   */
  public void initCategory() {
    categoryChoices.setOnAction(event -> {
      category = categoryChoices.getValue().toString();
    });
  }
}
