package cs3500.pa05.model;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.io.IOException;
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
  private double percentTasksCompleted;
  private String password;

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
    this.maximumTasks = 0;
    this.maximumEvents = 0;
    this.percentTasksCompleted = 0.0;
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
      this.percentTasksCompleted = Double.parseDouble(formattedPercentage);
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

  public void removeEvent(Event event) {
    allEvents.remove(event);
    removeEventFromDay(event);
  }

  public void removeTask(Task task) {
    allTasks.remove(task);
    removeTaskFromDay(task);
  }

  private void removeEventFromDay(Event event) {
    Days day = determineDay(event);
    if (day.equals(Days.MONDAY)) {
      monday.removeEvent(event);
    } else if (day.equals(Days.TUESDAY)) {
      tuesday.removeEvent(event);
    } else if (day.equals(Days.WEDNESDAY)) {
      wednesday.removeEvent(event);
    } else if (day.equals(Days.THURSDAY)) {
      thursday.removeEvent(event);
    } else if (day.equals(Days.FRIDAY)) {
      friday.removeEvent(event);
    } else if (day.equals(Days.SATURDAY)) {
      saturday.removeEvent(event);
    } else if (day.equals(Days.SUNDAY)) {
      sunday.removeEvent(event);
    }
  }

  private void removeTaskFromDay(Task task) {
    Days day = determineDay(task);
    if (day.equals(Days.MONDAY)) {
      monday.removeTask(task);
    } else if (day.equals(Days.TUESDAY)) {
      tuesday.removeTask(task);
    } else if (day.equals(Days.WEDNESDAY)) {
      wednesday.removeTask(task);
    } else if (day.equals(Days.THURSDAY)) {
      thursday.removeTask(task);
    } else if (day.equals(Days.FRIDAY)) {
      friday.removeTask(task);
    } else if (day.equals(Days.SATURDAY)) {
      saturday.removeTask(task);
    } else if (day.equals(Days.SUNDAY)) {
      sunday.removeTask(task);
    }
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
   * sets the password of this week
   *
   * @param password the password to be used
   */
  public void setPassword(String password) {
    this.password = password;
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
    try {
      ObjectMapper mapper = new ObjectMapper();
      String content = mapper.writeValueAsString(this);
      return content;
    } catch (IOException e) {
      System.err.println("Unable to parse to Json");
    }
    return null;
  }

  /**
   * Get the maximum events that can be set in a week
   *
   * @return maximum events in a week
   */
  public int getMaximumEvents() {
    return this.maximumEvents;
  }

  /**
   * Get the maximum tasks that can be set in a week
   *
   * @return maximum tasks in a week
   */
  public int getMaximumTasks() {
    return this.maximumTasks;
  }

  /**
   * Get the list of quotes and notes for the week
   *
   * @return list of quotes and notes
   */
  public List<String> getQuotesAndNotes() {
    return this.quotesAndNotes;
  }

  /**
   * Get all the events for the week
   *
   * @return list of all events
   */
  public List<Event> getAllEvents() {
    return this.allEvents;
  }

  /**
   * getter method for the week name
   *
   * @return gets the name of the week
   */
  public String getName() {
    return this.name;
  }

  /**
   * getter method for the password of this week
   *
   * @return the password of this week
   */
  public String getPassword() {
    return password;
  }

  /**
   * getter method for the monday of this week
   *
   * @return the monday of this week
   */
  public Monday getMonday() {
    return monday;
  }

  /**
   * getter method for the tuesday of this week
   *
   * @return the tuesday of this week
   */
  public Tuesday getTuesday() {
    return tuesday;
  }

  /**
   * getter method for the wednesday of this week
   *
   * @return the wednesday of this week
   */
  public Wednesday getWednesday() {
    return wednesday;
  }

  /**
   * getter method for the thursday of this week
   *
   * @return the thursday of this week
   */
  public Thursday getThursday() {
    return thursday;
  }

  /**
   * getter method for the friday of this week
   *
   * @return the friday of this week
   */
  public Friday getFriday() {
    return friday;
  }

  /**
   * getter method for the saturday of this week
   *
   * @return the saturday of this week
   */
  public Saturday getSaturday() {
    return saturday;
  }

  /**
   * getter method for the sunday of this week
   *
   * @return the sunday of this week
   */
  public Sunday getSunday() {
    return sunday;
  }
}
