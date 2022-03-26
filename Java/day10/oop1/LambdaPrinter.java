package day10.oop1;

public class LambdaPrinter {
    public static void main(String[] args) {
        StringFunction sf = s -> s.toUpperCase();
        StringFunction sf2 = s -> s.toLowerCase();
        StringFunction sf3 = new StringFunction() {
            @Override
            public String apply(String input) {
                return input.toLowerCase();
            }
        };
        System.out.println(sf);
        System.out.println(sf2);
        System.out.println(sf3);
    }
}

@FunctionalInterface
interface StringFunction {
    String apply(String input);
}


