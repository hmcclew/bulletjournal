package cs3500.pa05.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class NewEventController implements Controller {

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

    public NewEventController(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void run() throws IllegalStateException {
        initRadioButtons();
        initFinishButton();
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
