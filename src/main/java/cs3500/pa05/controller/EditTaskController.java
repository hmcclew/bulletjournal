package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

  public EditTaskController(Task task, Stage stage, VBox vbox, Week week,
                            JavaJournalController controller)  {
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

  public void initSetInitialChangeStatusText() {
    if (task.isComplete()) {
      newStatus.setText("Mark as Incomplete");
    } else {
      newStatus.setText("Mark as Complete");
    }
  }

  private void updateChangeStatusButtonText() {
    if (newStatus.getText().equals("Mark as Complete")) {
      newStatus.setText("Mark as Incomplete");
    } else {
      newStatus.setText("Mark as Complete");
    }
  }
  private void initChangeStatus() {
    newStatus.setOnAction(event -> {
      try {
        updateChangeStatusButtonText();
      } catch (IllegalStateException exc) {
        System.err.println("An Unexpected error occurred.");
      }
    });
  }

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
        stage.close();
      } catch (IllegalStateException exc) {
        System.err.println("An error occurred. Task Could not be Edited");
      }
    });
  }

  private void determineNewStatus() {
    if (newStatus.getText().equals("Mark as Incomplete")) {
      task.markAsComplete();
    } else {
      task.markAsIncomplete();
    }
  }

  private void determineNewDay() {
    if (day != null) {
      task.setDay(day.toUpperCase());
    }
  }

  /**
   * sets the category of the task
   */
  private void determineNewCategory() {
    if (category.equals("No Category")) {
      task.setCategory("");
    }
    else if (category != null) {
      task.setCategory(category);
    }
  }

  private void determineNewNameAndDescription() {
    if (newName.getText() != "") {
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
