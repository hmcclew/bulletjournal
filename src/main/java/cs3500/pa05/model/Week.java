package cs3500.pa05.model;

import cs3500.pa05.model.assignments.Assignment;
import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.Monday;
import cs3500.pa05.model.day.Tuesday;
import cs3500.pa05.model.day.Wednesday;
import cs3500.pa05.model.day.Thursday;
import cs3500.pa05.model.day.Friday;
import cs3500.pa05.model.day.Saturday;
import cs3500.pa05.model.day.Sunday;
import cs3500.pa05.model.day.Days;
import cs3500.pa05.model.day.Day;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public void setMaximumEvents(int maximumEvents) {
        this.maximumEvents = maximumEvents;
    }

    public void setMaximumTasks(int maximumTasks) {
        this.maximumTasks = maximumTasks;
    }

    public List<Task> getAllTasks() {
        return this.allTasks;
    }

    public double getPercentTasksCompleted() {
        int numTasksCompleted = 0;
        for (Task task : allTasks) {
            if (task.isComplete()) {
                numTasksCompleted++;
            }
        } if (numTasks() == 0) {
            return 0;
        } else {
            double ratio = (double) numTasksCompleted / numTasks();
            double percentage = ratio * 100;
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            String formattedPercentage = decimalFormat.format(percentage);
            return Double.parseDouble(formattedPercentage);
        }
    }

    public int numEvents() {
        return this.allEvents.size();
    }

    public int numTasks() {
        return this.allTasks.size();
    }

    public void addNoteOrQuote(String note) {
        quotesAndNotes.add(note);
    }

    public void addEvent(Event e) {
        allEvents.add(e);
        updateDayWithEvent(e);
    }

    public void addTask(Task t) {
        allTasks.add(t);
        updateDayWithTask(t);
    }

    public Days determineDay(Assignment a) {
       return Days.valueOf(a.getDay());
    }

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

    public List<String> getCategories() {
        return this.categories;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean maxTasksExceeded() {
        List<Day> days = new ArrayList<>(Arrays.asList(monday, tuesday, wednesday, thursday,
                friday, saturday, saturday));
        boolean exceeded = false;
        for (Day day : days) {
            if (day.getTasks().size() >= maximumTasks) {
                exceeded = true;
            }
        } return exceeded;
    }

    public boolean maxEventsExceeded() {
        List<Day> days = new ArrayList<>(Arrays.asList(monday, tuesday, wednesday, thursday,
                friday, saturday, saturday));
        boolean exceeded = false;
        for (Day day : days) {
            if (day.getEvents().size() >= maximumEvents) {
                exceeded = true;
            }
        } return exceeded;
    }

    public String toJsonFormat() {
      return "";
    }
}
