package cs3500.pa05.controller;

import cs3500.pa05.model.JavaJournalModel;
import cs3500.pa05.view.NewEventView;
import cs3500.pa05.view.NewTaskView;
import cs3500.pa05.view.SetMaximumView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaJournalController implements Controller {

  private JavaJournalModel model;

  @FXML
  private Button newEvent;

  @FXML
  private Button newTask;

  @FXML
  private Button setMaxEventsTasks;


  @Override
  public void run() throws IllegalStateException {
    initButtons();
  }

  private void initButtons() {
    initNewEvent();
    initNewTask();
    initSetMax();
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
        System.err.println("Unable to load GUI.");
      }
    });
  }

  private void initNewEvent() {
    newEvent.setOnAction(event -> {
      try {
        Stage newEventStage = new Stage();
        NewEventController controller = new NewEventController(newEventStage);
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
