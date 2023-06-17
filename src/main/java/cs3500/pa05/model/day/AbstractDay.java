package cs3500.pa05.model.day;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import java.util.ArrayList;
import java.util.List;

/**
 * abstract class for a day in java journal
 */
public abstract class AbstractDay implements Day {
  protected List<Event> events;
  protected List<Task> tasks;

  public AbstractDay() {
    this.events = new ArrayList<>();
    this.tasks = new ArrayList<>();
  }

  public List<Task> getTasks() {
    return this.tasks;
  }

  public List<Event> getEvents() {
    return this.events;
  }

  public void addEvent(Event e) {
    events.add(e);
  }

  public void addTask(Task t) {
    tasks.add(t);
  }

  public abstract String toJsonFormat();
}
