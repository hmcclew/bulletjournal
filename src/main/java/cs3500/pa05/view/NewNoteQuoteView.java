package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

public class NewNoteQuoteView extends AbstractView {

  public NewNoteQuoteView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("newNoteOrQuote.fxml"));
    this.loader.setController(controller);
  }
}
