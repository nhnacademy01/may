package day7.oop1;

import java.util.Scanner;

public class Echo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String input = sc.nextLine();
            System.out.println(input);
            if ("bye".equalsIgnoreCase(input)) {
                break;
            }
        }
    }
}
