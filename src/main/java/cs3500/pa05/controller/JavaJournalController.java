package cs3500.pa05.controller;

import cs3500.pa05.model.week.Week;
import cs3500.pa05.view.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaJournalController implements Controller {

  private Week week = new Week();

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


  @Override
  public void run() throws IllegalStateException {
    initButtons();
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
        SetMaxController controller = new SetMaxController(newMaxStage);
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

  private void initNewEvent() {
    newEvent.setOnAction(event -> {
      try {
        Stage newEventStage = new Stage();
        NewEventController controller = new NewEventController(newEventStage, week);
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
        NewTaskController controller = new NewTaskController();
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
