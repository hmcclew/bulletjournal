package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OpenTemplateController implements Controller {

  private Week week;

  private Stage stage;

  private JavaJournalController controller;

  @FXML
  private Button openFile;

  @FXML
  private Button openTemplate;

  public OpenTemplateController(Stage stage, Week week, JavaJournalController controller) {
    this.stage = stage;
    this.week = week;
    this.controller = controller;
  }

  /**
   * runs the controller
   *
   * @throws IllegalStateException if an exception is encountered
   */
  @Override
  public void run() throws IllegalStateException {
    initOpenFile();
    initOpenFileAsTemplate();
  }

  public void initOpenFile() {
    openFile.setOnAction(event -> {
      try {
        controller.openWeek(week);
        stage.close();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to open Week." + exc.getMessage());
      }
    });
  }

  public void initOpenFileAsTemplate() {
    openTemplate.setOnAction(event -> {
      try {
        Week templateWeek = new Week();
        controller.setWeek(templateWeek);
        initTemplateCategories(templateWeek);
        initTemplateMaximums(templateWeek);
        controller.setWeek(templateWeek);
        controller.openWeek(templateWeek);
        stage.close();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to open Template." + exc.getMessage());
      }
    });
  }

  public void initTemplateMaximums(Week templateWeek) {
    int maxEvents = week.getMaximumEvents();
    int maxTasks = week.getMaximumTasks();
    templateWeek.setMaximumEvents(maxEvents);
    templateWeek.setMaximumTasks(maxTasks);
  }

  public void initTemplateCategories(Week templateWeek) {
    for (String category : week.getCategories()) {
      templateWeek.addCategory(category);
    }
  }
}
