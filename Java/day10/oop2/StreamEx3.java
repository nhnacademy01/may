package day10.oop2;

import java.util.List;
import java.util.stream.IntStream;

public class StreamEx3 {
    public static void main(String[] args) {
        StreamEx3 ex = new StreamEx3();
        ex.practice();
    }

    private void practice() {
        int result = IntStream.rangeClosed(1, 100)
                .filter(this::isOdd)
                .sum();
        System.out.println("result = " + result);
    }

    private boolean isOdd(int i) {
        return i % 2 == 1;
    }
}



/*
1 ~ 100 까지의 숫자 중 홀수의 합을 스트림 사용하여 출력해주세요.

Hint :  IntStream.rangeClosed, filter, sum

 */