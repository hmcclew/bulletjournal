package cs3500.pa05.model.week;

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

    public Week() {
        this.quotesAndNotes = new ArrayList<>();
    }

    public void addNoteOrQuote(String note) {
        quotesAndNotes.add(note);
    }

    public void addCategory() {

    }

    public String toJsonFormat() {
        return null;
    }

}
