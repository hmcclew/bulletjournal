package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controller for editing an event
 */
public class EditEventController extends AbstractEventController implements Controller {

  private Event editedEvent;

  private Stage stage;

  private VBox currentWeekViewDescription;

  private String description;

  private String name;

  private String duration;

  private String startTime;

  private JavaJournalController controller;

  @FXML
  private Button saveEvent;

  @FXML
  private TextField newName;

  @FXML
  private TextField newDescription;

  /**
   * Constructor for an edit event controller
   *
   * @param event      the event being edited
   * @param stage      the stage for the editing window
   * @param vbox       the week display of the task
   * @param week       the week containing this task
   * @param controller the main controller
   */
  public EditEventController(Event event, Stage stage, VBox vbox, Week week,
                             JavaJournalController controller) {
    this.editedEvent = event;
    this.stage = stage;
    this.currentWeekViewDescription = vbox;
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
    initRadioButtons();
    initCategories();
    initCategory();
    initTextFields();
    initSaveButton();
  }

  /**
   * initializes the save button
   */
  public void initSaveButton() {
    saveEvent.setOnAction(event -> {
      try {
        week.removeEvent(editedEvent);
        VBox parent = (VBox) currentWeekViewDescription.getParent();
        parent.getChildren().remove(currentWeekViewDescription);
        determineNewNameAndDescription();
        determineNewDay();
        determineNewCategory();
        determineNewStartTime();
        determineNewDuration();
        week.addEvent(editedEvent);
        controller.updateAssignmentDisplay(editedEvent);
        controller.displayMaxEventsWarning();
        stage.close();
      } catch (IllegalStateException exc) {
        System.err.println("An error occurred. Task Could not be Edited");
      }
    });
  }

  /**
   * determines the new start time of the event
   */
  private void determineNewStartTime() {
    if (!startTimeHoursContent.getText().equals("0")
        ||
        !startTimeMinutesContent.getText().equals("0")) {
      if (startTimeMinutesContent.equals("0")) {
        startTime = startTimeHoursContent.getText() + ":00";
      } else {
        startTime = startTimeHoursContent.getText() + ":" + startTimeMinutesContent.getText();
      }
      editedEvent.setStartTime(startTime);
    }
  }

  /**
   * determines the new duration of the event
   */
  private void determineNewDuration() {
    if (!durationHoursContent.getText().equals("0")
        ||
        !durationMinutesContent.getText().equals("0")) {
      duration = durationHoursContent.getText() + " hours and " + durationMinutesContent.getText()
          + " minutes";
      editedEvent.setDuration(duration);
    }
  }

  /**
   * determines the new day of the event
   */
  private void determineNewDay() {
    if (day != null) {
      editedEvent.setDay(day.toUpperCase());
    }
  }

  /**
   * sets the category of the event
   */
  private void determineNewCategory() {
    if (category != null) {
      if (category.equals("No Category")) {
        editedEvent.setCategory("");
      } else {
        editedEvent.setCategory(category);
      }
    }
  }

  /**
   * determines the new name and description of the event
   */
  private void determineNewNameAndDescription() {
    if (!newName.getText().equals("")) {
      name = newName.getText();
    } else {
      name = editedEvent.getName();
    }
    editedEvent.setName(name);

    if (newDescription.getText() != "") {
      description = newDescription.getText();
    } else {
      description = editedEvent.getDescription();
    }
    editedEvent.setDescription(description);
  }
}
