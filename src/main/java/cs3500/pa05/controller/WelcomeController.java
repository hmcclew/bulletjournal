package cs3500.pa05.controller;

import cs3500.pa05.model.Week;
import cs3500.pa05.view.WeekView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Controller for a welcome screen
 */
public class WelcomeController implements Controller {

  private Stage stage;

  /**
   * constructor for a welcome controller
   *
   * @param stage the stage being displayed
   */
  public WelcomeController(Stage stage) {
    this.stage = stage;
  }

  /**
   * runs the controller
   *
   * @throws IllegalStateException if an exception is encountered
   */
  @Override
  public void run() throws IllegalStateException {
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> {
      Week week = new Week();
      JavaJournalController controller = new JavaJournalController(week, stage);
      WeekView view = new WeekView(controller);
      stage.setTitle("New Java Journal Week");
      stage.setScene(view.load());
      controller.run();
      stage.show();
    }));
    timeline.play();
  }
}
