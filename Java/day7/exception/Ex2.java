package day7.exceotion;

public class Ex2 {
    public static void main(String[] args) {
        int num = 0;
        try {
            num = Integer.parseInt("ABC");
        } catch (NumberFormatException cause) {
            num = 0;
        }
        System.out.println("num: " + num);
    }
}
