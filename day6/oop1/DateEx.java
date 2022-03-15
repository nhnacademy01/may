package day7.oop1;

import java.util.Date;

public class DateEx {
    public static void main(String[] args) {
        Date date = new Date();

        System.out.println("date: " + date);
        System.out.println("year: " + date.getYear());
        System.out.println("month: " + date.getMonth());
        System.out.println("date: " + date.getDate());
        System.out.println("dayOfWeek: " + date.getDay());
        System.out.println("hours: " + date.getHours());
        System.out.println("minutes: " + date.getMinutes());
        System.out.println("seconds: " + date.getSeconds());

        System.out.println("date.after(new Date()): " + date.after(new Date()));
        System.out.println("date.before(new Date()): " + date.before(new Date()));
        System.out.println("date.getTime(): " + date.getTime());
        System.out.println("date.compareTo(new Date()): " + date.compareTo(new Date())); // Comparab
    }
}
