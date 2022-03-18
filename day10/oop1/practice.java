//package day10.oop1;
//
//import java.util.Scanner;
//import java.util.function.ToLongFunction;
//import java.util.function.UnaryOperator;
//
//public class practice {
//    private  void compose() {
//        Scanner sc = new Scanner(System.in);
//        String text = sc.next();
//
//        UnaryOperator<String> f2 = s -> s.toUpperCase();
//        Function<String, char[]> f3 = s -> s.toCharArray();
//        Function<char[], Long> f4 = chs -> sumChars(chs);
//        Function<String, Long> func = f2.andThen(f3).andThen(f4);
//
//    }
//}
//
