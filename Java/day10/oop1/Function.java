package day10.oop1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Function<S, T> {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Welcome");
        list.add("NHN");
        list.add("Academy");
        // Predicate
        list.removeIf(s -> s.equals("NHN"));
        // Supplier(RandomNumberGenerator) : 랜던 숫자 제공
        Supplier<Integer> rng = () -> new Random().nextInt(10);
        // Function(UnaryOperator) : 소문자로 바꾸고 뒤에 랜덤 숫자 붙여서 반환
        list.replaceAll(s -> s.toLowerCase() + rng.get());
        // Consumer : 목록 요소 별로 출력(소비)
        list.forEach(s -> {
            System.out.print(s + " ");
        });
    }
}