package day7.oop1;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class Convert {
    public static void main(String[] args) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();

        LocalDateTime dt1 = LocalDateTime.ofInstant(date.toInstant(), ZoneOffset.UTC);
        OffsetDateTime odt1 = OffsetDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());
        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(cal.toInstant(), ZoneId.systemDefault());

        System.out.println(date + " " + date.getTimezoneOffset());
        System.out.println(cal.getTime() + " " + cal.getTimeZone().getID());
        System.out.println(dt1);
        System.out.println(odt1);
        System.out.println(zdt1);
    }
}
