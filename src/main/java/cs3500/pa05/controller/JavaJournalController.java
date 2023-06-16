package cs3500.pa05.controller;

import cs3500.pa05.model.JavaJournalModel;
import cs3500.pa05.model.week.Week;
import cs3500.pa05.view.NewEventView;
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


  @Override
  public void run() throws IllegalStateException {
    initButtons();
  }

  private void initButtons() {
    initNewEvent();
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
        System.err.println("Unable to load GUI." + exc.getMessage());
      }
    });
  }
  private void handleOpenFile() {

  }

  private void handleSaveToFile() {

  }

  private void handleShowSideBar() {

  }

  private void handleMaximumAssignmentsExceeded() {

  }
  private void handleCreateAssignment() {

  }

  private void handleCompletedTask() {

  }
  private void initTask() {

  }

  private void initEvent() {

  }

  private void initWeek() {

  }
}
