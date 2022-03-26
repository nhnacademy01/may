package day10.oop1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class LambdaExample {
    public static void main(String[] args) {
        LambdaExample e = new LambdaExample();
        e.before();
    }

    private void before() {
        List<String> names = Arrays.asList("jordan", "coco", "comtin", "manty");
        names.replaceAll(s -> s.toUpperCase());
        System.out.println(names);
    }
}
