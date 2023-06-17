package cs3500.pa05.model;

import cs3500.pa05.model.assignments.Assignment;
import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.Day;
import cs3500.pa05.model.day.Days;
import cs3500.pa05.model.day.Friday;
import cs3500.pa05.model.day.Monday;
import cs3500.pa05.model.day.Saturday;
import cs3500.pa05.model.day.Sunday;
import cs3500.pa05.model.day.Thursday;
import cs3500.pa05.model.day.Tuesday;
import cs3500.pa05.model.day.Wednesday;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing a week in a java journal
 */
public class Week {
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
  private List<String> quotesAndNotes;
  private int maximumEvents;
  private int maximumTasks;

  /**
   * Constructor for a week
   */
  public Week() {
    this.quotesAndNotes = new ArrayList<>();
    this.categories = new ArrayList<>();
    this.allEvents = new ArrayList<>();
    this.allTasks = new ArrayList<>();
    this.monday = new Monday();
    this.tuesday = new Tuesday();
    this.wednesday = new Wednesday();
    this.thursday = new Thursday();
    this.friday = new Friday();
    this.saturday = new Saturday();
    this.sunday = new Sunday();
  }

  /**
   * set the maximum events for this week
   *
   * @param maximumEvents the new maximum events for any day
   */
  public void setMaximumEvents(int maximumEvents) {
    this.maximumEvents = maximumEvents;
  }

  /**
   * set the maximum tasks for this week
   *
   * @param maximumTasks the new maximum tasks for any day
   */
  public void setMaximumTasks(int maximumTasks) {
    this.maximumTasks = maximumTasks;
  }

  /**
   * Get all of this week's tasks
   *
   * @return this week's tasks
   */
  public List<Task> getAllTasks() {
    return this.allTasks;
  }

  /**
   * calculates the percent of completed tasks this week
   *
   * @return the percentage of this week's completed tasks
   */
  public double getPercentTasksCompleted() {
    int numTasksCompleted = 0;
    for (Task task : allTasks) {
      if (task.isComplete()) {
        numTasksCompleted++;
      }
    }
    if (numTasks() == 0) {
      return 0;
    } else {
      double ratio = (double) numTasksCompleted / numTasks();
      double percentage = ratio * 100;
      DecimalFormat decimalFormat = new DecimalFormat("#.00");
      String formattedPercentage = decimalFormat.format(percentage);
      return Double.parseDouble(formattedPercentage);
    }
  }

  /**
   * gets the number of events in this week
   *
   * @return the number of events in this week
   */
  public int numEvents() {
    return this.allEvents.size();
  }

  /**
   * gets the number of tasks in this week
   *
   * @return the number of tasks in this week
   */
  public int numTasks() {
    return this.allTasks.size();
  }

  /**
   * adds a new string to the notes and quotes of this week
   *
   * @param note the note to be added
   */
  public void addNoteOrQuote(String note) {
    quotesAndNotes.add(note);
  }

  /**
   * adds an event to this week's events
   *
   * @param e the event to be added
   */
  public void addEvent(Event e) {
    allEvents.add(e);
    updateDayWithEvent(e);
  }

  /**
   * adds a task to this week's tasks
   *
   * @param t the task to be added
   */
  public void addTask(Task t) {
    allTasks.add(t);
    updateDayWithTask(t);
  }

  /**
   * determines the day of a given assignment in this week
   *
   * @param a the assignment
   * @return the day the assignment occurs
   */
  public Days determineDay(Assignment a) {
    return Days.valueOf(a.getDay());
  }

  /**
   * updates the day of the week based on the day of the given event
   *
   * @param e the event used to update the week
   */
  private void updateDayWithEvent(Event e) {
    Days day = determineDay(e);
    if (day.equals(Days.MONDAY)) {
      monday.addEvent(e);
    } else if (day.equals(Days.TUESDAY)) {
      tuesday.addEvent(e);
    } else if (day.equals(Days.WEDNESDAY)) {
      wednesday.addEvent(e);
    } else if (day.equals(Days.THURSDAY)) {
      thursday.addEvent(e);
    } else if (day.equals(Days.FRIDAY)) {
      friday.addEvent(e);
    } else if (day.equals(Days.SATURDAY)) {
      saturday.addEvent(e);
    } else if (day.equals(Days.SUNDAY)) {
      sunday.addEvent(e);
    }
  }

  /**
   * updates the day of the week based on the day of the given task
   *
   * @param t the task used to update the week
   */
  private void updateDayWithTask(Task t) {
    Days day = determineDay(t);
    if (day.equals(Days.MONDAY)) {
      monday.addTask(t);
    } else if (day.equals(Days.TUESDAY)) {
      tuesday.addTask(t);
    } else if (day.equals(Days.WEDNESDAY)) {
      wednesday.addTask(t);
    } else if (day.equals(Days.THURSDAY)) {
      thursday.addTask(t);
    } else if (day.equals(Days.FRIDAY)) {
      friday.addTask(t);
    } else if (day.equals(Days.SATURDAY)) {
      saturday.addTask(t);
    } else if (day.equals(Days.SUNDAY)) {
      sunday.addTask(t);
    }
  }

  /**
   * returns the categories of this week
   *
   * @return this week's categories as a deep copy
   */
  public List<String> getCategories() {
    ArrayList<String> categoryList = new ArrayList<>();
    for (String category : this.categories) {
      categoryList.add(category);
    }
    return categoryList;
  }

  /**
   * adds a category to this week's categories
   *
   * @param category the category to be added
   */
  public void addCategory(String category) {
    categories.add(category);
  }

  /**
   * sets the name of this week
   *
   * @param name the name to be used
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * determines if the maximum tasks for any day this week have been exceeded
   *
   * @return whether the maximum tasks for any day this week have been exceeded
   */
  public boolean maxTasksExceeded() {
    List<Day> days = new ArrayList<>(Arrays.asList(monday, tuesday, wednesday, thursday,
        friday, saturday, saturday));
    boolean exceeded = false;
    for (Day day : days) {
      if (day.getTasks().size() >= maximumTasks) {
        exceeded = true;
      }
    }
    return exceeded;
  }

  /**
   * determines if the maximum events for any day this week have been exceeded
   *
   * @return whether the maximum events for any day this week have been exceeded
   */
  public boolean maxEventsExceeded() {
    List<Day> days = new ArrayList<>(Arrays.asList(monday, tuesday, wednesday, thursday,
        friday, saturday, saturday));
    boolean exceeded = false;
    for (Day day : days) {
      if (day.getEvents().size() >= maximumEvents) {
        exceeded = true;
      }
    }
    return exceeded;
  }

  /**
   * returns the week as a json string
   *
   * @return the formatted json string
   */
  public String toJsonFormat() {
    return "";
  }
}
