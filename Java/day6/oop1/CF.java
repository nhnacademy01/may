package day7.oop1;

import java.text.ChoiceFormat;

public class CF {
    public static void main(String[] args) {
        // n >= 0: F, n >= 60: D, n >= 70: C, n >= 80: B, n >= 90: A
        double[] minScores = {0, 60, 70, 80, 90};
        String[] grades = {"F", "D", "C", "B", "A"};
        ChoiceFormat gradesFormat = new ChoiceFormat(minScores, grades);

        double[] scores = new double[]{75.6d, 88.8d, 97.3d, 43.3d};
        for (double score : scores) {
            System.out.printf("%.1f => %s%n", score, gradesFormat.format(score));
        }
    }
}