package cs3500.pa05.model.day;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import java.util.List;

/**
 * Interface for a day of the week in java journal
 */
public interface Day {

  List<Task> getTasks();

  List<Event> getEvents();

  void addEvent(Event e);

  void addTask(Task t);

  String toJsonFormat();
}
