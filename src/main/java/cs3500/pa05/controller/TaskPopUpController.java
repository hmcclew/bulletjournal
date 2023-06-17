package cs3500.pa05.controller;

import cs3500.pa05.model.assignments.Task;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class TaskPopUpController implements Controller {
  @FXML
  private Label name;

  @FXML
  private Label description;

  @FXML
  private Label day;

  @FXML
  private Button markAsComplete;

  @FXML
  private Label category;

  private Task task;

  private JavaJournalController controller;

  public TaskPopUpController(Task t, JavaJournalController controller) {
    this.task = t;
    this.controller = controller;
  }

  @Override
  public void run() throws IllegalStateException {
    determineName();
    description.setText("Description: " + task.getDescription());
    day.setText("Day: " + task.getDay());
    category.setText("Category: " + task.getCategory());
    initMarkAsComplete();
  }

  private void determineName() {
    if (task.isComplete()) {
      name.setText("COMPLETED TASK: " + task.getName());
    } else {
      name.setText("Task: " + task.getName());
    }
  }

  private void initMarkAsComplete() {
    HBox parent = (HBox) markAsComplete.getParent();
    if (task.isComplete()) {
      parent.getChildren().remove(markAsComplete);
    }
    markAsComplete.setOnAction(event -> {
      task.markAsComplete();
      parent.getChildren().remove(markAsComplete);
      name.setText("COMPLETED TASK: " + task.getName());
      controller.updateStatistics();
    });
  }
}
