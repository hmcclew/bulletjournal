package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateCategoryController implements Controller {
    @FXML
    private Button finish;
    @FXML
    private TextField categoryName;
    private Stage stage;
    private Week week;
    private String category;

    public CreateCategoryController(Stage stage, Week week) {
        this.stage = stage;
        this.week = week;
    }
    @Override
    public void run() throws IllegalStateException {
        initFinishButton();
    }

    private void initFinishButton() {
        finish.setOnAction(event -> {
            if (categoryName.getText() != "") {
                category = categoryName.getText();
                week.addCategory(category);
            }
            stage.close();
        });
    }
}
