package cs3500.pa05.controller;

import cs3500.pa05.model.week.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NewNoteQuoteController implements Controller {

    private Stage stage;

    private Week week;

    private String noteText;

    @FXML
    private TextField newNoteContent;

    @FXML
    private Button finish;

    public NewNoteQuoteController(Stage stage, Week week) {
        this.stage = stage;
        this.week = week;
    }
    @Override
    public void run() throws IllegalStateException {
        initFinishButton();
    }

    private void initFinishButton() {
        finish.setOnAction(event -> {
            if (newNoteContent.getText() != "") {
                noteText = newNoteContent.getText();
                week.addNoteOrQuote(noteText);
            }
            stage.close();
        });
    }
}
