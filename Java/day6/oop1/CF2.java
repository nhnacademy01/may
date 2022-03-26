package day7.oop1;

import java.text.ChoiceFormat;

public class CF2 {
    public static void main(String[] args) {
        //  0<=n<60: F, 60<=n<70: D, 70<=n<80: C, 80<=n<90: B, 90<=n<=100: A
        String pattern = "-1#Not score | 0#F | 60#D | 70#C | 80#B | 90#A | 100<Not score";
        ChoiceFormat gradesFormat = new ChoiceFormat(pattern);

        double[] scores = new double[]{-2d, 0d, 75.6d, 88.8d, 97.3d, 43.3d, 101d};
        for (double score : scores) {
            System.out.printf("%.1f => %s%n", score, gradesFormat.format(score));
        }
    }
}
