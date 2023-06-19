package cs3500.pa05.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;

/**
 * Abstract Class for editing and creating an even
 */
public class AbstractEventController extends AbstractNewAssignmentController {

  @FXML
  protected TextField durationHoursContent;
  @FXML
  protected TextField durationMinutesContent;
  @FXML
  protected TextField startTimeHoursContent;
  @FXML
  protected TextField startTimeMinutesContent;

  /**
   * initializes the text fields to only take integer inputs up to two digits
   */
  public void initTextFields() {
    startTimeHoursContent.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 0,
        c -> c.getControlNewText().matches("\\d{0,2}") ? c : null));
    startTimeMinutesContent.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 0,
        c -> c.getControlNewText().matches("\\d{0,2}") ? c : null));
    durationMinutesContent.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 0,
        c -> c.getControlNewText().matches("\\d{0,2}") ? c : null));
    durationHoursContent.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), 0,
        c -> c.getControlNewText().matches("\\d{0,2}") ? c : null));
  }
}
