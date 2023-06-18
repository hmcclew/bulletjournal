package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Task;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Controller for searching for tasks
 */
public class TaskSearchController implements Controller {

  private Week week;

  @FXML
  private VBox searchResults;

  @FXML
  private TextField searchBar;

  /**
   * Constructor for a task search controller
   *
   * @param week the week with tasks being searched
   */
  public TaskSearchController(Week week) {
    this.week = week;
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

  /**
   * initializes the listener in the search bar text field
   */
  private void initSearchBar() {
    searchBar.textProperty().addListener((observable, oldValue, newValue) -> {
      updateSearchResults(newValue);
    });
  }

  /**
   * updates the displayed search results based the content in the search bar
   *
   * @param searchText the content in the search bar
   */
  private void updateSearchResults(String searchText) {
    searchResults.getChildren().clear();

    for (Task task : week.getAllTasks()) {
      if (task.getName().toLowerCase().contains(searchText.toLowerCase())) {
        initTaskDisplay(task);
      }
    }
  }

  /**
   * initializes the display of a task in the search results
   *
   * @param task the task being formatted
   */
  private void initTaskDisplay(Task task) {
    VBox taskBox = new VBox();
    taskBox.setPadding(new Insets(0, 0, 20, 110));
    Label taskName = new Label(task.getName());
    taskName.setPadding(new Insets(0, 0, 0, 80));
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

  /**
   * initializes all search results when the tab is first opened
   * to show all tasks
   */
  private void initSearchResults() {
    for (Task task : week.getAllTasks()) {
      initTaskDisplay(task);
    }
  }
}
