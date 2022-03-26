package day10.oop2;

import java.util.List;

public class StreamEx2 {
    public static void main(String[] args) {
        StreamEx2 ex = new StreamEx2();
        ex.practice();
    }

    private void practice() {
        List<String> messages = List.of("Welcome", "NHN", "Academy");
        int sum = messages.stream()
                .map(String::toUpperCase)
                .flatMapToInt(String::chars)   //3번과 4-1번 실행
                .peek(c -> System.out.print(c + " "))
                .sum();
        System.out.println("sum = " + sum);
    }
}

/*
1.	영어 문자열을 입력 받는다.	String
2.	문자열을 대문자로 변환한다	String	String
3.	문자열을 문자배열(char[])로 변환한다	String	char[]
4-1.	ㄴ 문자들를 아스키코드로 변환한다.	char[]	int[]
4-2.	ㄴ 아스키코드의 합을 구한다.	int[]	long
 */

