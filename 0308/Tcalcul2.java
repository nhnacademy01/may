import java.util.Objects;
import java.util.Scanner;

public class Tcalcul2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val1 = 0;
        int val2 = 0;
        int answer = 0;
        System.out.println("어떤 연산을 하실건가요? (+,-,*,/)");
        String tt = sc.next();
        System.out.println("피연산자 2수를 입력하세요.");
        val1 = Integer.parseInt(sc.next());
        val2 = Integer.parseInt(sc.next());
        answer = calcul(val1, val2, tt);
        do {
            System.out.println("어떤 연산을 계속 하실건가요? (+,-,*,/)");
            String tt2 = sc.next();
            System.out.println("수를 입력하세요.");
            val1 = Integer.parseInt(sc.next());
            answer = calcul(answer, val1,tt2);
        } while(true);

    }
    static int calcul(int v1, int v2, String cal) {
        int ans = 0;
        if (Objects.equals(cal, "+")) {
            ans = v1 + v2;
            System.out.println(v1 + " + " + v2 + " = " + ans + "입니다.");
        }
        else if (Objects.equals(cal, "-")) {
            ans = v1 - v2;
            System.out.println(v1 + " - " + v2 + " = " + ans + "입니다.");
        }
        else if (Objects.equals(cal, "*")) {
            ans = v1 * v2;
            System.out.println(v1 + " * " + v2 + " = " + ans + "입니다.");
        }
        else if (Objects.equals(cal, "/")) {
            ans = v1 / v2;
            System.out.println(v1 + " / " + v2 + " = " + ans + "입니다.");

        }
        return ans;
    }

}
