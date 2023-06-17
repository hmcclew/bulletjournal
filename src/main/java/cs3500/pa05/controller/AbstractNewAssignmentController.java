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

  /**
   * button for selecting monday
   */
  @FXML
  protected RadioButton monday;

  /**
   * button for selecting tuesday
   */
  @FXML
  protected RadioButton tuesday;

  /**
   * button for selecting wednesday
   */
  @FXML
  protected RadioButton wednesday;

  /**
   * button for selecting thursday
   */
  @FXML
  protected RadioButton thursday;

  /**
   * button for selecting friday
   */
  @FXML
  protected RadioButton friday;

  /**
   * button for selecting saturday
   */
  @FXML
  protected RadioButton saturday;

  /**
   * button for selecting sunday
   */
  @FXML
  protected RadioButton sunday;

  /**
   * category choices
   */
  @FXML
  protected ChoiceBox<String> categoryChoices;

  /**
   * string representing new assignment category
   */
  protected String category;

  /**
   * string representing new assignment day
   */
  protected String day;

  /**
   * string representing new assignment week
   */
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
