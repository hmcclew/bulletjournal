package cs3500.pa05.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NewNoteQuoteController implements Controller {

    private Stage stage;

    private String noteText;

    @FXML
    private Button finish;

    public NewNoteQuoteController(Stage stage) {
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
