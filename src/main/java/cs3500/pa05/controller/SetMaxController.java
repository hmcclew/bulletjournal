package cs3500.pa05.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SetMaxController implements Controller {

    private Stage stage;

    @FXML
    private Button finish;
    public SetMaxController(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void run() throws IllegalStateException {
        initFinishButton();
    }

    private void initFinishButton() {
        finish.setOnAction(event -> {
            stage.close();
        });
    }

}
