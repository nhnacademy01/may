import java.util.Random;
import java.util.Scanner;

public class RandomGenerator {
    public static void main(String[] args) {
        Random random = new Random();
        int result = random.nextInt();
        Scanner scanner = new Scanner(System.in);
        int command;
        int result10;
        do {
            System.out.println("숫자를 맞춰주세요. (1~20): ");
            command = Integer.parseInt(scanner.next());
            result10 = random.nextInt(20) + 1;
            if (command > result10){
                System.out.println("더 작은 값이에요. " );}
            else if (command < result10){
                    System.out.println("더 큰 값이에요. ");}
        } while (command == result10);
        System.out.println(command + "정답입니다.");
    }
}
