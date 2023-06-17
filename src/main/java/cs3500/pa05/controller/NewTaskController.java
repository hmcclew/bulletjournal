package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * controller for creating a new task
 */
public class NewTaskController extends AbstractNewAssignmentController implements Controller {

  private Stage stage;
  @FXML
  private Button finish;
  @FXML
  private TextField nameContent;
  @FXML
  private TextField descriptionContent;
  private String name;
  private String description;
  private Task task;
  private JavaJournalController controller;

  /**
   * Constructor for a new task controller
   *
   * @param stage the stage displayed for creating a new task
   * @param week the week the task belongs to
   * @param controller the main controller
   */
  public NewTaskController(Stage stage, Week week, JavaJournalController controller) {
    this.stage = stage;
    this.week = week;
    this.controller = controller;
  }

  /**
   * runs the controller
   *
   * @throws IllegalStateException if the scene could not be loaded
   */
  @Override
  public void run() throws IllegalStateException {
    initRadioButtons();
    initCategories();
    initFinishButton();
    initCategory();
  }

  /**
   * initializes the finish button in the window for creating a task
   */
  private void initFinishButton() {
    finish.setOnAction(event -> {
      if (nameContent.getText() != ""
          && day != null) {
        name = nameContent.getText();
        if (descriptionContent.getText() != "") {
          description = descriptionContent.getText();
          task = new Task(name, day, description);
          setCategory();
        } else {
          task = new Task(name, day);
          setCategory();
        }
        week.addTask(task);
        controller.updateAssignmentDisplay(task);
        controller.updateStatistics();
        controller.displayMaxTasksWarning();
      } else {
        showInvalidTaskAlert();
      }

      stage.close();
    });
  }

  /**
   * sets the category of the task
   */
  private void setCategory() {
    if (category != null) {
      task.setCategory(category);
    }
  }

  /**
   * displays an alert if the entered fields are invalid for creating a new task
   */
  private void showInvalidTaskAlert() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Invalid Task");
    alert.setHeaderText(null);
    alert.setContentText("Task could not be created because you "
        +
        "left one or more required fields blank.");
    alert.showAndWait();
  }
}
