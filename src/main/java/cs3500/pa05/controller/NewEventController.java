package cs3500.pa05.controller;

import cs3500.pa05.model.week.Week;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

    private String nameContent;

    private String descriptionContent;

    private String startHour;

    private String startMin;

    private String durationHours;

    private String durationMins;

    private String category;

    public NewEventController(Stage stage, Week week) {
        this.stage = stage;
        this.week = week;
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
            stage.close();
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
    }

}
