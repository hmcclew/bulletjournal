package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class NewTaskController implements Controller {

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
    private String day;
    private String name;
    private String description;
    private String category;
    private Task t;
    private JavaJournalController controller;

    public NewTaskController(Stage stage, Week week, JavaJournalController controller) {
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

    private void initCategory() {
        categoryChoices.setOnAction(event -> {
            category = categoryChoices.getValue().toString();
        });
    }

    private void initFinishButton() {
        finish.setOnAction(event -> {
            if (nameContent.getText() != ""
                    && day != null) {
                name = nameContent.getText();
                if (descriptionContent.getText() != "") {
                    description = descriptionContent.getText();
                    t = new Task(name, day, description);
                    setCategory();
                } else {
                    t = new Task(name, day);
                    setCategory();
                }
                week.addTask(t);
                controller.updateAssignmentDisplay(t);
                controller.updateStatistics();
            } else {
                showInvalidTaskAlert();
            }

            stage.close();
        });
    }

    private void showInvalidTaskAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Invalid Task");
        alert.setHeaderText(null);
        alert.setContentText("Task could not be created because you left one or more required fields blank.");
        alert.showAndWait();
    }

    private void setCategory() {
        if (category != null) {
            t.setCategory(category);
        }
    }

    private void initCategories() {
        for (String category : week.getCategories()) {
            categoryChoices.getItems().add(category);
        }
        categoryChoices.setDisable(false);
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
