package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;


/**
 * View class for a Java Journal week
 */
public class WeekView implements JavaJournalView {

  FXMLLoader loader;

  /**
   * Constructor for a week view
   *
   * @param controller the controller for this view
   */
  public WeekView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("week.fxml"));
    this.loader.setController(controller);
  }

  /**
   * Loads a scene from the Java Journal
   *
   * @return the layout
   */
  @Override
  public Scene load() throws IllegalStateException {
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
