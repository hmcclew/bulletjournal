package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.view.TemplateNamePromptView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TemplateNamePromptController implements Controller {

  private Week week;

  private Stage stage;

  private JavaJournalController controller;

  @FXML
  private TextField weekName;


  @FXML
  private Button saveAndOpen;

  public TemplateNamePromptController(JavaJournalController controller, Stage stage, Week week) {
    this.controller = controller;
    this.stage = stage;
    this.week = week;
  }

  /**
   * runs the controller
   *
   * @throws IllegalStateException if an exception is encountered
   */
  @Override
  public void run() throws IllegalStateException {
    initSaveAndOpen();
  }

  public void initSaveAndOpen() {
    saveAndOpen.setOnAction(event -> {
      try {
        initTemplateName(week);
        controller.setWeek(week);
        controller.openWeek(week);
        stage.close();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to open Template." + exc.getMessage());
      }
    });
  }

  private void initTemplateName(Week week) {
    String newName = weekName.getText();
    week.setName(newName);
  }
}
