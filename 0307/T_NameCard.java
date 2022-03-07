import java.util.Scanner;

public class NameCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = null;
        System.out.println("input name : ");
        if (scanner.hasNext()) {
            name = scanner.nextLine();
        }
        String email = null;
        System.out.println("input email :");
        if (scanner.hasNext()) {
            email = scanner.next();
        }
        String mobile = null;
        System.out.println("input mobile :");
        if (scanner.hasNext()) {
            mobile = scanner.next();
        }
        System.out.printf("   name : %20s%n", name);
        System.out.printf("  email : %20s%n", email);
        System.out.printf(" mobile : %20s%n", mobile);

    }
}
