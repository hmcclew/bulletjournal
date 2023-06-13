package cs3500.pa05.model.day;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import java.util.List;

public abstract class AbstractDay implements Day {
  private List<Event> events;
  private List<Task> tasks;

  private int maximumTasks;

  private int maximumEvents;

  public List<Task> getTasks() {
    return this.tasks;
  }

  public List<Event> getEvents() {
    return this.events;
  }

  public void addEvent() {

  }
  public void addTask() {

  }
  public abstract String toJsonFormat();
  public abstract String getDayOfTheWeek();
}
