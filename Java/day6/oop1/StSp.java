package day7.oop1;

import java.util.StringTokenizer;

public class StSp {
    public static void main(String[] args) {
        String input = "50,20,,,40,30";
        // split
        String[] tokens = input.split(",");  //구분자로 정규표현식을 사용
        int countBySplit = tokens.length;
        System.out.println("countBySplit: " + countBySplit);
        System.out.println("tokensBySplit");
        for (String token : tokens) {
            System.out.printf("'%s' ", token);
        }
        // StringTokenizer
        StringTokenizer st = new StringTokenizer(input, ","); //문자만 구분자로 사용
        int countBySt = st.countTokens();
        System.out.printf("%n%ncountBySt: %d%n", countBySt);
        System.out.println("tokensBySt");
        while (st.hasMoreTokens()) {
            System.out.printf("'%s' ", st.nextToken());
        }
    }
}
