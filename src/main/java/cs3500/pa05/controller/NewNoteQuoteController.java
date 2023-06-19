package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Controller for creating a new note or quote
 */
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

  /**
   * Constructor for a new note or quote controller
   *
   * @param stage the stage for creating the note
   * @param week the week the note will belong to
   * @param noteBox the box for the note to be displayed in the main week view
   */
  public NewNoteQuoteController(Stage stage, Week week, VBox noteBox) {
    this.stage = stage;
    this.week = week;
    this.noteBox = noteBox;
  }

  /**
   * runs the controller
   *
   * @throws IllegalStateException if the scene could not load
   */
  @Override
  public void run() throws IllegalStateException {
    initFinishButton();
  }

  /**
   * initializes the finish button
   */
  private void initFinishButton() {
    finish.setOnAction(event -> {
      if (newNoteContent.getText() != "") {
        noteText = newNoteContent.getText();
        week.addNoteOrQuote(noteText);
        Label label = new Label(noteText);
        label.setWrapText(true);
        noteBox.getChildren().add(label);
      }
      stage.close();
    });
  }
}
