package day7.oop1;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularQuiz {
    public static void main(String[] args) {
        String str = "032-0032-0320\n" +
                "032-0031-0311\n" +
                "031-031-0310\n" +
                "031-031-0322";
        regexp3(str);
    }

    private static void regexp3(String str) {
        Pattern p = Pattern.compile("(\\s)(031)");
        Matcher m = p.matcher(str);
        StringBuffer result = new StringBuffer();
        while (m.find()) {
            String space = m.group(1);
            m.appendReplacement(result, space + "032");
        }
        m.appendTail(result);
        System.out.println(result);
    }
}
