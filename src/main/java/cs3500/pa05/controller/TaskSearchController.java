package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.view.TaskPopUpView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
        initTaskButton(task);
      }
    }
  }

  private void initTaskButton(Task task) {
    Button taskButton = new Button(task.getName());
    taskButton.setPrefWidth(380);
    taskButton.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-underline: true;");
    controller.initTaskDisplay(taskButton, task);
    searchResults.getChildren().add(taskButton);
  }

  private void initSearchResults() {
    for (Task task : week.getAllTasks()) {
      initTaskButton(task);
    }
  }
}
