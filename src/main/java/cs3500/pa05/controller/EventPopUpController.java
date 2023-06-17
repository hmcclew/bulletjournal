package cs3500.pa05.controller;

import cs3500.pa05.model.assignments.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Class for the controller for an event pop up
 */
public class EventPopUpController implements Controller {
  @FXML
  private Label name;

  @FXML
  private Label description;

  @FXML
  private Label day;

  @FXML
  private Label startTime;

  @FXML
  private Label duration;

  @FXML
  private Label category;

  private Event event;

  /**
   * Constructor for an event pop up controller
   *
   * @param e the event in the popup
   */
  public EventPopUpController(Event e) {
    this.event = e;
  }

  /**
   * runs the controller
   *
   * @throws IllegalStateException if unable to load
   */
  @Override
  public void run() throws IllegalStateException {
    name.setText("Event: " + event.getName());
    description.setText("Description: " + event.getDescription());
    day.setText("Day: " + event.getDay());
    category.setText("Category: " + event.getCategory());
    startTime.setText("Start Time: " + event.getStartTime());
    duration.setText("Duration: " + event.getDuration());
  }
}
