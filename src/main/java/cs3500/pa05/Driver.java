package cs3500.pa05;

import cs3500.pa05.controller.WelcomeController;
import cs3500.pa05.view.WelcomeView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Driver Class for Java Journal
 */
public class Driver extends Application {


  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    launch();
  }

  /**
   * The main entry point for all JavaFX applications.
   * * The start method is called after the init method has returned,
   * * and after the system is ready for the application to begin running.
   *
   * @param stage the primary stage for this application, onto which
   *              the application scene can be set.
   *              Applications may create other stages, if needed, but they will not be
   *              primary stages.
   */
  @Override
  public void start(Stage stage) {
    WelcomeController controller = new WelcomeController(stage);
    WelcomeView view = new WelcomeView(controller);
    try {
      stage.setTitle("Welcome to Java Journal");
      stage.setScene(view.load());
      controller.run();
      stage.show();
    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI." + exc.getMessage());
    }
  }
}
