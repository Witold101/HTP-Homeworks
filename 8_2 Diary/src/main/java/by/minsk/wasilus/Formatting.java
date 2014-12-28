package by.minsk.wasilus;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;

/**
 * Created by Witold on 27.12.2014.
 */
public class Formatting {

    private static DateFormatSymbols myDateFormatSymbols = new DateFormatSymbols() {
        @Override
        public String[] getMonths() {
            return new String[]{"января в ", "февраля в ", "марта в ", "апреля в ", "мая в ", "июня в ",
                    "июля в ", "августа в ", "сентября в ", "октября в ", "ноября в ", "декабря в "};
        }
    };

    private static int maxDaysMonth(int month, int year) {
        int rezult = 0;
        switch (month) {
            case Calendar.JANUARY:
                rezult = 31;
                break;
            case Calendar.FEBRUARY:
                if (year % 4 == 0) {
                    rezult = 29;
                } else {
                    rezult = 28;
                }
                break;
            case Calendar.MARCH:
                rezult = 31;
                break;
            case Calendar.APRIL:
                rezult = 30;
                break;
            case Calendar.MAY:
                rezult = 31;
                break;
            case Calendar.JUNE:
                rezult = 30;
                break;
            case Calendar.JULY:
                rezult = 31;
                break;
            case Calendar.AUGUST:
                rezult = 31;
                break;
            case Calendar.SEPTEMBER:
                rezult = 30;
                break;
            case Calendar.OCTOBER:
                rezult = 31;
                break;
            case Calendar.NOVEMBER:
                rezult = 30;
                break;
            case Calendar.DECEMBER:
                rezult = 31;
                break;
        }
        return rezult;
    }

    private static int considerDays(Calendar calendar) {
        int allDais = ((calendar.get(Calendar.YEAR) - 1) * 365) + ((calendar.get(Calendar.YEAR) - 1) / 4);
        for (int i = 0; i <= calendar.get(Calendar.MONTH) - 1; i++) {
            allDais = allDais + maxDaysMonth(i, calendar.get(Calendar.YEAR));
        }
        return allDais + calendar.get(Calendar.DATE);
    }

    private static int compareCalendars(Calendar first, Calendar second) {
        return considerDays(first) - considerDays(second);
    }

    public static String formattingDate(Date event) {
        Calendar calendarEvent = new GregorianCalendar();
        calendarEvent.setTime(event);
        Calendar calendarToday = new GregorianCalendar();
        calendarToday.setTime(new Date());

        if (compareCalendars(calendarToday, calendarEvent) == 0) {
            return new SimpleDateFormat("HH:mm").format(calendarEvent.getTime());
        } else if (compareCalendars(calendarToday, calendarEvent) == 1) {
            return new SimpleDateFormat("ВЧЕРА HH:mm ").format(calendarEvent.getTime());
        } else if ((compareCalendars(calendarToday, calendarEvent) < 8) &&
                (compareCalendars(calendarToday, calendarEvent) > 1)) {
            return calendarToday.get(Calendar.DATE) - calendarEvent.get(Calendar.DATE) +
                    new SimpleDateFormat(" дней назад. HH:mm").format(calendarEvent.getTime());
        } else if (compareCalendars(calendarToday, calendarEvent) > 7) {
            return new SimpleDateFormat("ДАВНО HH:mm ").format(calendarEvent.getTime());
        } else if ((compareCalendars(calendarToday, calendarEvent) < 0) &&
                (compareCalendars(calendarToday, calendarEvent) > -8)) {
            return new SimpleDateFormat("dd MMMM HH:mm", myDateFormatSymbols).format(calendarEvent.getTime());
        } else if (compareCalendars(calendarToday, calendarEvent) < -7) {
            return new SimpleDateFormat("EEEE, dd MMMM").format(calendarEvent.getTime());
        } else {
            return "НИЧЕГО";
        }
    }

}
