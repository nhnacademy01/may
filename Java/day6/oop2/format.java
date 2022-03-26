package day7.oop2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class format {
    public static void main(String[] args) {
        String input = "1980-01-01 16:16:16";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime date = LocalDateTime.parse(input, formatter);
        System.out.println(date);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String output = date.format(format);
        System.out.println(output);
    }
}
