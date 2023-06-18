package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.view.TaskPopUpView;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaskSearchController implements Controller{

  private Week week;

  private JavaJournalController controller;

  @FXML
  private VBox searchResults;

  @FXML
  private TextField searchBar;

  public TaskSearchController(Week week, JavaJournalController controller) {
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
    initSearchBar();
    initSearchResults();
  }

  private void initSearchBar() {
    searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
      updateSearchResults(newValue);
    });
  }

  private void updateSearchResults(String searchText) {
    searchResults.getChildren().clear();

    for (Task task : week.getAllTasks()) {
      if (task.getName().toLowerCase().contains(searchText.toLowerCase())) {
        initTaskDisplay(task);
      }
    }
  }

  private void initTaskDisplay(Task task) {
    VBox taskBox = new VBox();
    taskBox.setPadding(new Insets(0,0,20,120));
    Label taskName = new Label(task.getName());
    taskName.setPadding(new Insets(0,0,0,70));
    taskName.setWrapText(true);
    Label taskDescription = new Label("Description: " + task.getDescription());
    taskDescription.setWrapText(true);
    taskDescription.setPadding(new Insets(0, 60, 0, 0));
    Label taskCategory = new Label("Category: " + task.getCategory());
    taskCategory.setWrapText(true);
    taskCategory.setPadding(new Insets(0, 60, 0, 0));
    Label taskDay = new Label("Day: " + task.getDay());
    if (task.isComplete()) {
      Label taskStatus = new Label("Status: Complete");
      taskBox.getChildren().addAll(taskName, taskDay, taskDescription, taskCategory, taskStatus);
    } else {
      Label taskStatus = new Label("Status: Not Complete");
      taskBox.getChildren().addAll(taskName, taskDay, taskDescription, taskCategory, taskStatus);
    }
    searchResults.getChildren().add(taskBox);
  }

  private void initSearchResults() {
    for (Task task : week.getAllTasks()) {
      initTaskDisplay(task);
    }
  }
}
