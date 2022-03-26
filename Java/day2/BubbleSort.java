import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        Random random = new Random();
        for (int i=0; i<numbers.length; i++) {
            numbers[i] = random.nextInt(20)+1;
            System.out.print(numbers[i]+" ");
        }
        System.out.println();

        for (int i=1; i<numbers.length; i++) {
            for (int j =0; j<numbers.length-i; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1]=tmp;
                }
            }
        }
        for (int i=0; i<numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
    }
}



