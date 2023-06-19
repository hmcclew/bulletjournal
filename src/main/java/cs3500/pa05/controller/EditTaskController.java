package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controller for editing a task
 */
public class EditTaskController extends AbstractNewAssignmentController implements Controller {

  private Task task;

  private Stage stage;

  private VBox currentWeekViewDescription;

  private String description;

  private String name;

  private JavaJournalController controller;

  @FXML
  private Button saveTask;

  @FXML
  private TextField newName;

  @FXML
  private TextField newDescription;

  @FXML
  private Button newStatus;

  /**
   * Constructor for an edit task controller
   *
   * @param task the task being edited
   * @param stage the stage for the editing window
   * @param vbox the week display of the task
   * @param week the week containing this task
   * @param controller the main controller
   */
  public EditTaskController(Task task, Stage stage, VBox vbox, Week week,
                            JavaJournalController controller) {
    this.task = task;
    this.stage = stage;
    this.currentWeekViewDescription = vbox;
    this.week = week;
    this.controller = controller;
  }

  /**
   * runs the controller
   *
   * @throws IllegalStateException if an exception is encountered
   */
  @Override
  public void run() throws IllegalStateException {
    initSaveButton();
    initRadioButtons();
    initCategories();
    initCategory();
    initChangeStatus();
    initSetInitialChangeStatusText();
  }

  /**
   * sets the initial text for changing the status of the task
   */
  public void initSetInitialChangeStatusText() {
    if (task.isComplete()) {
      newStatus.setText("Mark as Incomplete");
    } else {
      newStatus.setText("Mark as Complete");
    }
  }

  /**
   * updates the text for changing the status button
   */
  private void updateChangeStatusButtonText() {
    if (newStatus.getText().equals("Mark as Complete")) {
      newStatus.setText("Mark as Incomplete");
    } else {
      newStatus.setText("Mark as Complete");
    }
  }

  /**
   * initializes the change status button
   */
  private void initChangeStatus() {
    newStatus.setOnAction(event -> {
      try {
        updateChangeStatusButtonText();
      } catch (IllegalStateException exc) {
        System.err.println("An Unexpected error occurred.");
      }
    });
  }

  /**
   * initializes the save button
   */
  public void initSaveButton() {
    saveTask.setOnAction(event -> {
      try {
        VBox parent = (VBox) currentWeekViewDescription.getParent();
        parent.getChildren().remove(currentWeekViewDescription);
        determineNewNameAndDescription();
        determineNewDay();
        determineNewCategory();
        determineNewStatus();
        controller.updateAssignmentDisplay(task);
        controller.updateStatistics();
        stage.close();
      } catch (IllegalStateException exc) {
        System.err.println("An error occurred. Task Could not be Edited");
      }
    });
  }

  /**
   * determines the new status of the task
   */
  private void determineNewStatus() {
    if (newStatus.getText().equals("Mark as Incomplete")) {
      task.markAsComplete();
    } else {
      task.markAsIncomplete();
    }
  }

  /**
   * determines the new day of the task
   */
  private void determineNewDay() {
    if (day != null) {
      task.setDay(day.toUpperCase());
    }
  }

  /**
   * sets the category of the task
   */
  private void determineNewCategory() {
    if (category != null) {
      if (category.equals("No Category")) {
        task.setCategory("");
      } else {
        task.setCategory(category);
      }
    }
  }

  /**
   * determines the new name and description of the task
   */
  private void determineNewNameAndDescription() {
    if (!newName.getText().equals("")) {
      name = newName.getText();
    } else {
      name = task.getName();
    }
    task.setName(name);

    if (newDescription.getText() != "") {
      description = newDescription.getText();
    } else {
      description = task.getDescription();
    }
    task.setDescription(description);
  }
}
