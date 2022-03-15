package day7.oop1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEX {
    public static void main(String[] args) {
//        Pattern p = Pattern.compile("^c.*");    // 'c'로 시작하는 문자열
//        Matcher m = p.matcher("car");
//        if (m.matches()) {
//            System.out.println("Starts with 'c'");
//        } else {
//            System.out.println("Not starts with 'c'");
//        }
        Pattern p = Pattern.compile("([a-zA-Z0-9_.+-]+)@([a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+)");
        Matcher m = p.matcher("이메일은 hong@nhn.com 입니다.");
        StringBuilder result = new StringBuilder();
        while (m.find()) {
            String localPart = m.group(1);
            m.appendReplacement(result, localPart + "@nhnacademy.com");
        }
        m.appendTail(result);
        System.out.println(result);
    }
}
