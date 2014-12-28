package by.minsk.wasilus;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Witold on 26.12.2014.
 */
public class Event {
    private String name;
    private Date dateTime;
    private String message;

    public Event(String name, Date dateTime, String message) {
        this.name = name;
        this.dateTime = dateTime;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public String getMessage() {
        return message;
    }
}
