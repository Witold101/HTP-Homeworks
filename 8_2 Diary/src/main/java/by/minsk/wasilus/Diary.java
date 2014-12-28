package by.minsk.wasilus;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Witold on 26.12.2014.
 */
public class Diary {
    private List<Event> events;

    public Diary() {
        events = new ArrayList<Event>();
    }

    public List<Event> getEvents() {
        return events;
    }

    public void addEvent(Event event) {
        events.add(event);
    }
}
