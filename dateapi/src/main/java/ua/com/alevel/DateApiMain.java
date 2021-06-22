package ua.com.alevel;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateApiMain {

    public static void main(String[] args) {

    }

    private static void dateApi() {
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate);
        System.out.println(localDate.getYear());
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getDayOfMonth());

        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.now();
        System.out.println("offsetDateTime = " + offsetDateTime);
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        offsetDateTime = OffsetDateTime.now(timeZone.toZoneId());
        System.out.println("offsetDateTime = " + offsetDateTime);
    }

    private static void calendar() {
        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar = " + calendar.getTime());
        calendar.add(Calendar.DAY_OF_WEEK, 1);
        System.out.println("calendar = " + calendar.getTime());
    }

    private static void baseDate() {
        Date date = new Date();
        System.out.println("date = " + date.getTime());
        System.out.println(System.currentTimeMillis());

        date = new Date(Long.MAX_VALUE);
        System.out.println("date = " + date);

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println("timeZone = " + timeZone);
    }
}
