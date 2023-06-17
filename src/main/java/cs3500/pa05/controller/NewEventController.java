package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

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
    private Event e;
    private JavaJournalController controller;


    public NewEventController(Stage stage, Week week, JavaJournalController controller) {
        this.stage = stage;
        this.week = week;
        this.controller = controller;
    }

    @Override
    public void run() throws IllegalStateException {
        initRadioButtons();
        initCategories();
        initFinishButton();
        initCategory();
    }

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
                    e = new Event(name, day, startTime, duration, description);
                    setCategory();
                } else {
                    e = new Event(name, day, startTime, duration);
                    setCategory();
                }
                week.addEvent(e);
                controller.updateAssignmentDisplay(e);
                controller.updateStatistics();
                if (week.numEvents() == week.getMaximumEvents()) {
                    controller.displayMaxEventsWarning();
                }
            } else {
                showInvalidEventAlert();
            }

            stage.close();
        });
    }

    private void showInvalidEventAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Event");
        alert.setHeaderText(null);
        alert.setContentText("Event could not be created because you left one or more required fields blank.");
        alert.showAndWait();
    }

    private void setCategory() {
        if (category != null) {
            e.setCategory(category);
        }
    }

    private void determineName() {
        name = nameContent.getText();
    }

    private void determineStartTime() {
        startTime = startTimeHoursContent.getText() + ":" + startTimeMinutesContent.getText();
    }

    private void determineDuration() {
        duration = durationHoursContent.getText() + " hours and " + durationMinutesContent.getText()
                + " minutes";
    }

}
