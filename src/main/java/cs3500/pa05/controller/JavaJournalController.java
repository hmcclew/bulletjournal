package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Assignment;
import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.Days;
import cs3500.pa05.view.*;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaJournalController implements Controller {

  private Week week;

  @FXML
  private Button newEvent;

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
    button.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-underline: true;");
    if (assignment instanceof Event) {
      initEventDisplay(button, (Event) assignment);
    } else if (assignment instanceof Task) {

    }
    if (day.equals(Days.MONDAY)) {
      mondayContent.getChildren().add(button);
    } else if (day.equals(Days.TUESDAY)) {
      tuesdayContent.getChildren().add(button);
    } else if (day.equals(Days.WEDNESDAY)) {
      wednesdayContent.getChildren().add(button);
    } else if (day.equals(Days.THURSDAY)) {
      thursdayContent.getChildren().add(button);
    } else if (day.equals(Days.FRIDAY)) {
      fridayContent.getChildren().add(button);
    } else if (day.equals(Days.SATURDAY)) {
      saturdayContent.getChildren().add(button);
    } else if (day.equals(Days.SUNDAY)) {
      sundayContent.getChildren().add(button);
    }
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

  private void initSetMax() {
    setMaxEventsTasks.setOnAction(event -> {
      try {
        Stage newMaxStage = new Stage();
        SetMaxController controller = new SetMaxController(newMaxStage, week);
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
