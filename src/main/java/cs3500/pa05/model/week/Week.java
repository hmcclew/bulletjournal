package cs3500.pa05.model.week;

import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.Friday;
import cs3500.pa05.model.day.Monday;
import cs3500.pa05.model.day.Saturday;
import cs3500.pa05.model.day.Sunday;
import cs3500.pa05.model.day.Thursday;
import cs3500.pa05.model.day.Tuesday;
import cs3500.pa05.model.day.Wednesday;
import java.util.List;

public interface Week {
  Monday getMonday();
  Tuesday getTuesday();
  Wednesday getWednesday();
  Thursday getThursday();
  Friday getFriday();
  Saturday getSaturday();
  Sunday getSunday();
  List<Event> getAllEvents();
  List<Task> getAllTasks();

  String toJsonFormat();
}
