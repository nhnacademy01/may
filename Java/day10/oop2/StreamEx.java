package day10.oop2;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {
        StreamEx ex = new StreamEx();
        ex.flatMap();
    }

    private  void flatMap() {
        String[][] strs = new String[][] {
                {"Welcome", "NHN", "Academy"},
                {"I", "am", "Jordon"},
                {"Nice", "to", "meet", "you"}
        };
        Stream.of(strs)
//                .peek(a -> System.out.println(Arrays.toString(a)))
                .flatMap(Stream::of)
                .forEach(System.out::println);
    }
}

/*
String[][] strs = new String[][] {
                {"Welcome", "NHN", "Academy"},
                {"I", "am", "Jordon"},
                {"Nice", "to", "meet", "you"}
        };

        2차원 배열을 1차원 배열로 만들어주는 것.
     (위에서 아래로 바꿔주는 것 : flatMap)


String[] strs = new String[] {
                "Welcome", "NHN", "Academy",
                "I", "am", "Jordon",
                "Nice", "to", "meet", "you"
        };
 */
