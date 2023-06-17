package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NewNoteQuoteController implements Controller {

  private Stage stage;

  private Week week;

  private String noteText;

  @FXML
  private TextField newNoteContent;

  @FXML
  private Button finish;

  @FXML
  private VBox noteBox;

  public NewNoteQuoteController(Stage stage, Week week, VBox noteBox) {
    this.stage = stage;
    this.week = week;
    this.noteBox = noteBox;
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
        Label label = new Label(noteText);
        noteBox.getChildren().add(label);
      }
      stage.close();
    });
  }
}
