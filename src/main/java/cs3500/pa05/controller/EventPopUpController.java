package cs3500.pa05.controller;

import cs3500.pa05.model.assignments.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

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

  public EventPopUpController(Event e) {
    this.event = e;
  }

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
