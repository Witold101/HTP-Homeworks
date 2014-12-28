package by.minsk.wasilus;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.zone.ZoneRules;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Created by Witold on 26.12.2014.
 */
public class Main {
    public static void main(String[] args) {
        Diary diary = new Diary();

        diary.addEvent(new Event("Встреча", new Date(), "Встретиться с Сергеем"));
        diary.addEvent(new Event("Встреча", new Date(114, Calendar.DECEMBER, 27, 13, 25), "Встретиться с Сергеем"));
        diary.addEvent(new Event("Встреча", new Date(114, Calendar.DECEMBER, 24, 13, 25), "Встретиться с Сергеем"));
        diary.addEvent(new Event("Встреча", new Date(114, Calendar.DECEMBER, 15, 13, 25), "Встретиться с Сергеем"));
        diary.addEvent(new Event("Встреча", new Date(114, Calendar.DECEMBER, 31, 13, 25), "Встретиться с Сергеем"));
        diary.addEvent(new Event("Встреча", new Date(115, Calendar.JANUARY, 24, 13, 25), "Встретиться с Сергеем"));

        for (Event event : diary.getEvents()) {
            System.out.println(event.getName() + " - " + Formatting.formattingDate(event.getDateTime()) +
                    "\n" + event.getMessage() + "\n");
        }
    }
}
