package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.fxml.FXMLLoader;

/**
 * View for creating a new note or quote
 */
public class NewNoteQuoteView extends AbstractView {

  /**
   * Constructor for a new note quote view
   *
   * @param controller the controller fot this view
   */
  public NewNoteQuoteView(Controller controller) {
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("newNoteOrQuote.fxml"));
    this.loader.setController(controller);
  }
}
