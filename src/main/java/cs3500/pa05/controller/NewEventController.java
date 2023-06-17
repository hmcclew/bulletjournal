package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.day.Days;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NewEventController implements Controller {

    private Week week;

    private Stage stage;

    @FXML
    private RadioButton monday;
    @FXML
    private RadioButton tuesday;
    @FXML
    private RadioButton wednesday;
    @FXML
    private RadioButton thursday;
    @FXML
    private RadioButton friday;
    @FXML
    private RadioButton saturday;
    @FXML
    private RadioButton sunday;
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
    private String day;
    private String name;

    private String description;

    private String startTime;

    private String duration;

    private String category;

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
    }

    private void initCategories() {
        for (String category : week.getCategories()) {
            categoryChoices.getItems().add(category);
        }
    }

    private void initFinishButton() {
        finish.setOnAction(event -> {
            if (nameContent.getText() != ""
                    && day != null
            && startTimeHoursContent.getText() != ""
            && startTimeMinutesContent.getText() != ""
            && durationHoursContent.getText() != ""
            && durationMinutesContent.getText() != "") {
                determineCategory();
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
            }
            week.addEvent(e);
            controller.updateAssignmentDisplay(e);
            stage.close();
        });
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
        duration = durationHoursContent.getText() + ":" + durationMinutesContent.getText();
    }

    private void determineCategory() {
        categoryChoices.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                category = newValue.toString();
            }
        });
    }

    private void initRadioButtons() {
        ToggleGroup toggleGroup = new ToggleGroup();
        monday.setToggleGroup(toggleGroup);
        tuesday.setToggleGroup(toggleGroup);
        wednesday.setToggleGroup(toggleGroup);
        thursday.setToggleGroup(toggleGroup);
        friday.setToggleGroup(toggleGroup);
        saturday.setToggleGroup(toggleGroup);
        sunday.setToggleGroup(toggleGroup);

        toggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                RadioButton selectedRadioButton = (RadioButton) newValue;
                day = selectedRadioButton.getText();
            }
        });
    }

}
