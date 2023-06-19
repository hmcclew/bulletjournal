package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 * Controller for a password prompt
 */
public class PasswordPromptController implements Controller {

  private Stage stage;

  private Week week;

  private JavaJournalController controller;

  @FXML
  private Button enter;

  @FXML
  private Label invalidPassword;

  @FXML
  private PasswordField passwordEntered;

  /**
   * Constructor for a password prompt controller
   *
   * @param week the week
   * @param controller the main controller
   * @param stage the stage of the prompt
   */
  public PasswordPromptController(Week week, JavaJournalController controller,
                                  Stage stage) {
    this.week = week;
    this.controller = controller;
    this.stage = stage;
  }

  /**
   * runs the controller
   *
   * @throws IllegalStateException if an exception is encountered
   */
  @Override
  public void run() throws IllegalStateException {
    initEnterButton();
  }

  /**
   * initializes the enter button for the password prompt
   */
  private void initEnterButton() {
    enter.setOnAction(event -> {
      try {
        if (passwordEntered.getText().equals(week.getPassword())) {
          controller.openWeek(week);
          stage.close();
        } else {
          invalidPassword.setText("The password you have entered is incorrect. Please Try Again.");
        }
      } catch (IllegalStateException exc) {
        System.err.println("Unable to process password");
      }
    });
  }
}
