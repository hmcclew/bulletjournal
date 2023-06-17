package cs3500.pa05.model;

import cs3500.pa05.model.assignments.Assignment;
import cs3500.pa05.model.assignments.Event;
import cs3500.pa05.model.assignments.Task;
import cs3500.pa05.model.day.*;

import java.util.ArrayList;
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

    public int getMaximumEvents() {
        return this.maximumEvents;
    }

    public int getEvents() {
        return this.allEvents.size();
    }

    public void addNoteOrQuote(String note) {
        quotesAndNotes.add(note);
    }

    public void addEvent(Event e) {
        allEvents.add(e);
        updateDayWithEvent(e);
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

    public List<String> getCategories() {
        return this.categories;
    }

    public void addCategory(String category) {
        categories.add(category);
    }

    public String toJsonFormat() {
        return null;
    }

}
