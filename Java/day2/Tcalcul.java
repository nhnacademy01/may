import java.util.Objects;
import java.util.Scanner;

public class Tcalcul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("어떤 연산을 하실건가요? (+,-,*,/)");
        String tt = sc.next();
        System.out.println("피연산자 2수를 입력하세요.");
        if (Objects.equals(tt, "+")) {
            int val1 = Integer.parseInt(sc.next());
            int val2 = Integer.parseInt(sc.next());
            int sum = val1 + val2;
            System.out.println(val1 + " + " + val2 + " = " + sum + "입니다.");
        }
        else if (Objects.equals(tt, "-")) {
            int val1 = Integer.parseInt(sc.next());
            int val2 = Integer.parseInt(sc.next());
            int sub = val1 - val2;
            System.out.println(val1 + " - " + val2 + " = " + sub + "입니다.");
        }
        else if (Objects.equals(tt, "*")) {
            int val1 = Integer.parseInt(sc.next());
            int val2 = Integer.parseInt(sc.next());
            int mut = val1 * val2;
            System.out.println(val1 + " * " + val2 + " = " + mut + "입니다.");
        }
        else if (Objects.equals(tt, "/")) {
            int val1 = Integer.parseInt(sc.next());
            int val2 = Integer.parseInt(sc.next());
            int div = val1 / val2;
            System.out.println(val1 + " / " + val2 + " = " + div + "입니다.");
        }
        else {
            System.out.println("연산 기호를 잘 못 입력했습니다.");
        }
    }
}
