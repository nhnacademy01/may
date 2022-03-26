package day7.oop1;

import java.text.ChoiceFormat;

public class ChoiceFormatEx {
    public static void main(String[] args) {
        ChoiceFormatEx cf = new ChoiceFormatEx();
        cf.season();
    }
        private void season() {
            double[] minScores = {1, 3, 6, 9, 12};
            String[] seasons = {"겨울", "봄", "여름", "가을", "겨울"};
            ChoiceFormat gradesFormat = new ChoiceFormat(minScores, seasons);

            for (int i = 0; i <= 12; i++) {
                System.out.printf("%d월의 계절은 %s%n.", i, gradesFormat.format(i));
            }
        }
    }

