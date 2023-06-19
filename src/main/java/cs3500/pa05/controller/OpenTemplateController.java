package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.view.TemplateNamePromptView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
        initTemplateCategories(templateWeek);
        initTemplateMaximums(templateWeek);
        initTemplateNotes(templateWeek);
        TemplateNamePromptController templateNamePromptController = new TemplateNamePromptController(controller,
            stage, templateWeek);
        TemplateNamePromptView view = new TemplateNamePromptView(templateNamePromptController);
        stage.setScene(view.load());
        templateNamePromptController.run();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to open Template." + exc.getMessage());
      }
    });
  }


  private void initTemplateNotes(Week templateWeek) {
    for (String note : week.getQuotesAndNotes()) {
      templateWeek.addNoteOrQuote(note);
    }
  }

  private void initTemplateMaximums(Week templateWeek) {
    int maxEvents = week.getMaximumEvents();
    int maxTasks = week.getMaximumTasks();
    templateWeek.setMaximumEvents(maxEvents);
    templateWeek.setMaximumTasks(maxTasks);
  }

  private void initTemplateCategories(Week templateWeek) {
    for (String category : week.getCategories()) {
      templateWeek.addCategory(category);
    }
  }
}
