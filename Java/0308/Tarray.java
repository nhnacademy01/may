import java.util.Random;

public class Tarray {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        int cnt = 0;
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(20) + 1;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= 10) {
                cnt += 1;
            }
        }
        System.out.println("10이하인 수:" + cnt);
    }
}
