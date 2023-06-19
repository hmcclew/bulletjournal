package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.view.TemplateNamePromptView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Controller for opening a template
 */
public class OpenTemplateController implements Controller {

  private Week week;

  private Stage stage;

  private JavaJournalController controller;

  @FXML
  private Button openFile;

  @FXML
  private Button openTemplate;

  /**
   * constructor for an open template controller
   *
   * @param stage the stage being displayed
   * @param week the week being opened as a template
   * @param controller the main controller
   */
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

  /**
   * initializes the open file button
   */
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

  /**
   * initializes the open file as template button
   */
  public void initOpenFileAsTemplate() {
    openTemplate.setOnAction(event -> {
      try {
        Week templateWeek = new Week();
        initTemplateCategories(templateWeek);
        initTemplateMaximums(templateWeek);
        initTemplateNotes(templateWeek);
        TemplateNamePromptController templateNamePromptController = new
            TemplateNamePromptController(controller, stage, templateWeek);
        TemplateNamePromptView view = new TemplateNamePromptView(templateNamePromptController);
        stage.setScene(view.load());
        templateNamePromptController.run();
      } catch (IllegalStateException exc) {
        System.err.println("Unable to open Template." + exc.getMessage());
      }
    });
  }


  /**
   * initializes the notes for the template week
   *
   * @param templateWeek the template week
   */
  private void initTemplateNotes(Week templateWeek) {
    for (String note : week.getQuotesAndNotes()) {
      templateWeek.addNoteOrQuote(note);
    }
  }

  /**
   * initializes the maximum events and tasks for a week
   *
   * @param templateWeek the template week
   */
  private void initTemplateMaximums(Week templateWeek) {
    int maxEvents = week.getMaximumEvents();
    int maxTasks = week.getMaximumTasks();
    templateWeek.setMaximumEvents(maxEvents);
    templateWeek.setMaximumTasks(maxTasks);
  }

  /**
   * initializes the categories for a week
   *
   * @param templateWeek the template week
   */
  private void initTemplateCategories(Week templateWeek) {
    for (String category : week.getCategories()) {
      templateWeek.addCategory(category);
    }
  }
}
