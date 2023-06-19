package cs3500.pa05.model.day;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import java.util.List;

/**
 * Interface for a day of the week in java journal
 */
public interface Day {

  /**
   * getter method for the tasks of day
   *
   * @return all tasks for the day
   */
  List<Task> getTasks();

  /**
   * getter method for the events of day
   *
   * @return all events for the day
   */
  List<Event> getEvents();

  /**
   * adds an event to this day's events
   *
   * @param e the event to be added
   */
  void addEvent(Event e);

  /**
   * adds a task to this day's tasks
   *
   * @param t the task to be added
   */
  void addTask(Task t);

  /**
   * removes an event from this day's events
   *
   * @param e the event to be removed
   */
  void removeEvent(Event e);

  /**
   * removed a task from this day's tasks
   *
   * @param t the task to be removed
   */
  void removeTask(Task t);
}
