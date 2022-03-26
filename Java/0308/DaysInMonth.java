import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("월을 입력하세요: ");
        int month = scanner.nextInt();
        printDayInMonth(month);
//        printDayInMonth2(month);
    }

    private static void printDayInMonth(int month) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                System.out.println(month + "has 31 days.");
                break;
            case 4: case 6: case 9: case 11:
                System.out.println(month + "has 30 days.");
                break;
            case 2:
                System.out.println(month + "has 28 or 29 days.");
                break;
            default:
                System.out.println(month+ "is not a month.");
                break;

        }
    }
//    private static void printDayInMonth2(int month) {
//        int i = 1;
//        if (case==1 or case==3 or case==5 or case==7 or case==8 or case==10 or case==12) {
//
//        }
//    }
}
