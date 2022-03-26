package day7.oop1;

import org.w3c.dom.ls.LSOutput;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static java.time.temporal.ChronoUnit.MINUTES;

public class minusOneMinutes {

    public static void main(String[] args) {

        LocalDateTime dt = LocalDateTime.now();
        LocalDateTime dt1 = dt.minus(1L, MINUTES);
        LocalDateTime dt2 = dt.minusMinutes(1L);
        LocalDateTime dt3 = dt.minus(Duration.ofMinutes(1));

        System.out.println(dt);
        System.out.println(dt1);
        System.out.println(dt2);
        System.out.println(dt3);

    }
}
