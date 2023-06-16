package cs3500.pa05.controller;

import cs3500.pa05.model.JavaJournalModel;
import cs3500.pa05.model.week.Week;
import cs3500.pa05.view.NewEventView;
import cs3500.pa05.view.NewTaskView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaJournalController implements Controller {

  private JavaJournalModel model;

  @FXML
  private Button newEvent;

  @FXML
  private Button newTask;


  @Override
  public void run() throws IllegalStateException {
    initButtons();
  }

  private void initButtons() {
    initNewEvent();
    initNewTask();
  }

  private void initNewEvent() {
    newEvent.setOnAction(event -> {
      try {
        Stage newEventStage = new Stage();
        NewEventController controller = new NewEventController();
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
        newTaskStage.setTitle("Create New Event");
        newTaskStage.setScene(view.load());
        controller.run();
        newTaskStage.show();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to load GUI.");
      }
    });
  }

}
