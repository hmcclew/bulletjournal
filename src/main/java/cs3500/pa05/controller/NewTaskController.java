package cs3500.pa05.controller;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class NewTaskController implements Controller {

    @FXML
    private TextField name;

    @FXML
    private TextField description;

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

    @Override
    public void run() throws IllegalStateException {
        initButtons();
    }

    private void initButtons() {
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
