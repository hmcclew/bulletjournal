package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

/**
 * Controller for creating a new event
 */
public class NewEventController extends AbstractNewAssignmentController implements Controller {

  private Stage stage;
  @FXML
  private Button finish;
  @FXML
  private ChoiceBox categoryChoices;
  @FXML
  private TextField nameContent;
  @FXML
  private TextField descriptionContent;
  @FXML
  private TextField durationHoursContent;
  @FXML
  private TextField durationMinutesContent;
  @FXML
  private TextField startTimeHoursContent;
  @FXML
  private TextField startTimeMinutesContent;
  private String description;
  private String startTime;
  private String duration;
  private String name;
  private Event createdEvent;
  private JavaJournalController controller;

  /**
   * Constructor for a new event controller
   *
   * @param stage the stage for the popup window
   * @param week the week this event will belong to
   * @param controller the main controller
   */
  public NewEventController(Stage stage, Week week, JavaJournalController controller) {
    this.stage = stage;
    this.week = week;
    this.controller = controller;
  }

  /**
   * runs the controller
   *
   * @throws IllegalStateException if the run could not complete
   */
  @Override
  public void run() throws IllegalStateException {
    initRadioButtons();
    initCategories();
    initFinishButton();
    initCategory();
    initTextFields();
  }

  /**
   * initializes the text fields to only take integer inputs up to two digits
   */
  private void initTextFields() {
    startTimeHoursContent.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 0,
        c -> c.getControlNewText().matches("\\d{0,2}") ? c : null));
    startTimeMinutesContent.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 0,
        c -> c.getControlNewText().matches("\\d{0,2}") ? c : null));
    durationMinutesContent.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 0,
        c -> c.getControlNewText().matches("\\d{0,2}") ? c : null));
    durationHoursContent.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 0,
        c -> c.getControlNewText().matches("\\d{0,2}") ? c : null));
  }

  /**
   * initializes the finish button
   */
  private void initFinishButton() {
    finish.setOnAction(event -> {
      if (nameContent.getText() != ""
          && day != null
          && startTimeHoursContent.getText() != ""
          && startTimeMinutesContent.getText() != ""
          && durationHoursContent.getText() != ""
          && durationMinutesContent.getText() != "") {
        determineStartTime();
        determineDuration();
        determineName();
        if (descriptionContent.getText() != "") {
          description = descriptionContent.getText();
          createdEvent = new Event(name, day, startTime, duration, description);
          setCategory();
        } else {
          createdEvent = new Event(name, day, startTime, duration);
          setCategory();
        }
        week.addEvent(createdEvent);
        controller.updateAssignmentDisplay(createdEvent);
        controller.updateStatistics();
        controller.displayMaxEventsWarning();
      } else {
        showInvalidEventAlert();
      }

      stage.close();
    });
  }

  /**
   * displays an alert if the event could not be created
   */
  private void showInvalidEventAlert() {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Invalid Event");
    alert.setHeaderText(null);
    alert.setContentText("Event could not be created because "
        +
        "you left one or more required fields blank.");
    alert.showAndWait();
  }

  /**
   * sets the category of the created event
   */
  private void setCategory() {
    if (category != null) {
      createdEvent.setCategory(category);
    }
  }

  /**
   * determines the name of the created event
   */
  private void determineName() {
    name = nameContent.getText();
  }

  /**
   * determines the start time of the created event
   */
  private void determineStartTime() {
    startTime = startTimeHoursContent.getText() + ":" + startTimeMinutesContent.getText();
  }

  /**
   * determines the duration of the created event
   */
  private void determineDuration() {
    duration = durationHoursContent.getText() + " hours and " + durationMinutesContent.getText()
        + " minutes";
  }

}
