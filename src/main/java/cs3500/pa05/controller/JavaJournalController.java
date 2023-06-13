package cs3500.pa05.controller;

import cs3500.pa05.model.JavaJournalModel;
import cs3500.pa05.model.week.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.SplitPane;

public class JavaJournalController implements Controller {

  private JavaJournalModel model;

  private Week currentWeek;

  @FXML
  private Button openFile;

  @FXML
  private Button saveToFile;

  @FXML
  private Button showSideBar;

  @FXML
  private Button acceptWarning;

  @FXML
  private Button createAssignment;

  @FXML
  private ChoiceBox taskOrEvent;

  @FXML
  private Button completeCreatingAssignment;

  @FXML
  private Button markCompleteTask;

  @FXML
  private Button selectCategory;

  @FXML
  private Button addNewCategory;
  @FXML
  private ChoiceBox categories;

  @FXML
  private SplitPane sideBar;

  @Override
  public void run() throws IllegalStateException {

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
