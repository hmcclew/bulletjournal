package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class TaskSearchView extends AbstractView {

  public TaskSearchView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("task-search.fxml"));
    this.loader.setController(controller);
  }
}
