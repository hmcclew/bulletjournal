package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Assignment;
import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.Days;
import cs3500.pa05.model.writer.BujoFileWriter;
import cs3500.pa05.view.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class JavaJournalController implements Controller {

  private Week week;

  @FXML
  private TextField weekName;

  @FXML
  private Button newEvent;

  @FXML
  private Label taskWarning;

  @FXML
  private Label eventWarning;

  @FXML
  private Button newTask;

  @FXML
  private Button setMaxEventsTasks;

  @FXML
  private Button newNote;

  @FXML
  private VBox notesContent;

  @FXML
  private Button createCategory;

  @FXML
  private VBox sundayContent;

  @FXML
  private VBox mondayContent;

  @FXML
  private VBox tuesdayContent;

  @FXML
  private VBox wednesdayContent;

  @FXML
  private VBox thursdayContent;

  @FXML
  private VBox fridayContent;

  @FXML
  private VBox saturdayContent;

  @FXML
  private Label totalEvents;

  @FXML
  private Label totalTasks;

  @FXML
  private Label tasksCompleted;

  @FXML
  private Button saveFile;

  @FXML
  private Button showTaskQueue;

  @FXML
  private Label weeksTasks;

  @FXML
  private VBox tasksBox;

  @FXML
  private SplitPane sideBar;


  public JavaJournalController() {
    this.week = new Week();
  }


  @Override
  public void run() throws IllegalStateException {
    initButtons();
  }

  public void updateAssignmentDisplay(Assignment assignment) {
    Days day = week.determineDay(assignment);
    Button button = new Button(assignment.getName());
    button.setPrefWidth(200);
    button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-underline: true;");
    if (day.equals(Days.MONDAY)) {
      mondayContent.getChildren().add(button);
      initData(mondayContent, assignment);
    } else if (day.equals(Days.TUESDAY)) {
      tuesdayContent.getChildren().add(button);
      initData(tuesdayContent, assignment);
    } else if (day.equals(Days.WEDNESDAY)) {
      wednesdayContent.getChildren().add(button);
      initData(wednesdayContent, assignment);
    } else if (day.equals(Days.THURSDAY)) {
      thursdayContent.getChildren().add(button);
      initData(thursdayContent, assignment);
    } else if (day.equals(Days.FRIDAY)) {
      fridayContent.getChildren().add(button);
      initData(fridayContent, assignment);
    } else if (day.equals(Days.SATURDAY)) {
      saturdayContent.getChildren().add(button);
      initData(saturdayContent, assignment);
    } else if (day.equals(Days.SUNDAY)) {
      sundayContent.getChildren().add(button);
      initData(sundayContent, assignment);
    }
    if (assignment instanceof Event) {
      initEventDisplay(button, (Event) assignment);
    } else if (assignment instanceof Task) {
      initTaskDisplay(button, (Task) assignment);
    }
  }

  private void initData(VBox content, Assignment a) {
    if (a.getDescription() != "No Description Available.") {
      Label description = new Label("Description: " + a.getDescription());
      content.getChildren().add(description);
    }
    if (a.getCategory() != "No Category Available.") {
      Label category = new Label("Category: " + a.getCategory());
      content.getChildren().add(category);
    }
  }

  private void initTaskDisplay(Button button, Task t) {
    if (t.isComplete()) {
      button.setText(t.getName() + ": Complete");
    } else {
      button.setText(t.getName() + ": Not Complete");
    }
    button.setOnAction(event -> {
      try {
        Stage stage = new Stage();
        TaskPopUpController controller= new TaskPopUpController(t, this);
        TaskPopUpView view = new TaskPopUpView(controller);
        stage.setTitle(t.getName());
        stage.setScene(view.load());
        controller.run();
        stage.show();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to load GUI.");
      }
    });
  }

  private void initEventDisplay(Button button, Event e) {
    button.setOnAction(event -> {
      try {
        Stage stage = new Stage();
        EventPopUpController controller= new EventPopUpController(e);
        EventPopUpView view = new EventPopUpView(controller);
        stage.setTitle(e.getName());
        stage.setScene(view.load());
        controller.run();
        stage.show();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to load GUI.");
      }
    });
  }

  private void initButtons() {
    initNewEvent();
    initNewTask();
    initSetMax();
    initNewNote();
    initCreateCategory();
    initSaveFile();
    initShowSideBar();
  }

  private void initShowSideBar() {
    showTaskQueue.setOnAction(event -> {
      if (sideBar.getDividerPositions()[0] >= 0.1) {
        sideBar.setDividerPosition(0, 0.0);
        weeksTasks.setText("");
        tasksBox.getChildren().clear();
      } else if (sideBar.getDividerPositions()[0] <= 0.1) {
        sideBar.setDividerPosition(0, 0.2);
        tasksBox.getChildren().clear();
        weeksTasks.setText("This Week's Tasks");
        for (Task task : week.getAllTasks()) {
          if (task.isComplete()) {
            Label label = new Label(task.getName() + ": Complete");
            tasksBox.getChildren().add(label);
          } else {
            Label label = new Label(task.getName() + ": Not Complete");
            tasksBox.getChildren().add(label);
          }
        }
      }
    });
  }

  private void initSaveFile() {
    saveFile.setOnAction(event -> {
        week.setName(weekName.getText());
        saveFile();
    });
  }

  private void saveFile() {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Save File");

    FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Bujo (*.bujo)", "*.bujo");
    fileChooser.getExtensionFilters().add(extensionFilter);

    File file = fileChooser.showSaveDialog(null);

    if (file != null) {
      try {
        BujoFileWriter fileWriter = new BujoFileWriter();
        fileWriter.writeToFile(file.toPath(), week.toJsonFormat());
      } catch (Exception e) {
        System.out.println("An error occurred while saving the file.");
      }
    }
  }

  private void initNewNote() {
    newNote.setOnAction(event -> {
      try {
        Stage stage = new Stage();
        NewNoteQuoteController controller = new NewNoteQuoteController(stage, week, notesContent);
        NewNoteQuoteView view = new NewNoteQuoteView(controller);
        stage.setTitle("Add a New Note or Quote");
        stage.setScene(view.load());
        controller.run();
        stage.show();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to load GUI." + exc.getMessage());
      }
    });
  }
  private void initCreateCategory() {
    createCategory.setOnAction(event -> {
      try {
        Stage stage = new Stage();
        CreateCategoryController controller = new CreateCategoryController(stage, week);
        CreateCategoryView view = new CreateCategoryView(controller);
        stage.setTitle("Create a New Category for the Week");
        stage.setScene(view.load());
        controller.run();
        stage.show();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to load GUI." + exc.getMessage());
      }
    });
  }

  public void displayMaxEventsWarning() {
    if (week.maxEventsExceeded()) {
      eventWarning.setText("WARNING: You have reached your maximum number of events for at least one day.");
    } else {
      eventWarning.setText(" ");
    }
  }

  public void displayMaxTasksWarning() {
    if (week.maxTasksExceeded()) {
      taskWarning.setText("WARNING: You have reached your maximum number of tasks for at least one day.");
    } else {
      taskWarning.setText(" ");
    }
  }

  private void initSetMax() {
    setMaxEventsTasks.setOnAction(event -> {
      try {
        Stage newMaxStage = new Stage();
        SetMaxController controller = new SetMaxController(newMaxStage, week, this);
        SetMaximumView view = new SetMaximumView(controller);
        newMaxStage.setTitle("Set Maximum Tasks and Events");
        newMaxStage.setScene(view.load());
        controller.run();
        newMaxStage.show();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to load GUI." + exc.getMessage());
      }
    });

  }

  public void updateStatistics() {
    totalEvents.setText("Total Events: " + week.numEvents());
    totalTasks.setText("Total Tasks: " + week.numTasks());
    tasksCompleted.setText("Percent Tasks Completed: " + week.getPercentTasksCompleted() + "%");
  }

  private void initNewEvent() {
    newEvent.setOnAction(event -> {
      try {
        Stage newEventStage = new Stage();
        NewEventController controller = new NewEventController(newEventStage, week, this);
        NewEventView view = new NewEventView(controller);
        newEventStage.setTitle("Create New Event");
        newEventStage.setScene(view.load());
        controller.run();
        newEventStage.show();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to load GUI.");
      }
    });
  }

  private void initNewTask() {
    newTask.setOnAction(event -> {
      try {
        Stage newTaskStage = new Stage();
        NewTaskController controller = new NewTaskController(newTaskStage, week, this);
        NewTaskView view = new NewTaskView(controller);
        newTaskStage.setTitle("Create New Task");
        newTaskStage.setScene(view.load());
        controller.run();
        newTaskStage.show();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to load GUI.");
        exc.printStackTrace();
      }
    });
  }

}
