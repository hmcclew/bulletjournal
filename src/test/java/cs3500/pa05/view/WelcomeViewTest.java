package cs3500.pa05.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.controller.WelcomeController;
import javafx.stage.Stage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 * Tests the welcome view
 */
@ExtendWith(ApplicationExtension.class)
class WelcomeViewTest {

  WelcomeView view;

  @Start
  public void start(Stage stage) {
    WelcomeController controller = new WelcomeController(stage);
    view = new WelcomeView(controller);
    stage.setScene(view.load());
  }


}