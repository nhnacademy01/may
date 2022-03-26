import java.util.Scanner;

public class GradePrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("점수를 입력하세요: ");
        int score = scanner.nextInt();
        GradePrinter gradePrinter = new GradePrinter();
        gradePrinter.print(score);
        If.elseIfToTriOperator();
    }

    private void print(int score) {
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80 && score < 90) {
            System.out.println("B");
        } else if (score >= 70 && score < 80) {
            System.out.println("C");
        } else if (score >= 60 && score < 70) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }

    public static class If {
        static void elseIfToTriOperator() {
            int score = 91;
            String grade;
            grade = score >= 90 ? "A" : score >= 80 ? "B" : "C";
            System.out.println("Grade" + grade);
        }
    }
}

