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

public class JavaJournalWeek implements Week {
  private String name;
  private Monday monday;
  private Tuesday tuesday;
  private Wednesday wednesday;
  private Thursday thursday;
  private Friday friday;
  private Saturday saturday;
  private Sunday sunday;
  private List<String> categories;
  private List<Event> allEvents;
  private List<Task> allTasks;
  public void addCategory() {

  }

  public String toJsonFormat() {
    return null;
  }

  @Override
  public Monday getMonday() {
    return null;
  }

  @Override
  public Tuesday getTuesday() {
    return null;
  }

  @Override
  public Wednesday getWednesday() {
    return null;
  }

  @Override
  public Thursday getThursday() {
    return null;
  }

  @Override
  public Friday getFriday() {
    return null;
  }

  @Override
  public Saturday getSaturday() {
    return null;
  }

  @Override
  public Sunday getSunday() {
    return null;
  }

  @Override
  public List<Event> getAllEvents() {
    return null;
  }

  @Override
  public List<Task> getAllTasks() {
    return null;
  }
}
