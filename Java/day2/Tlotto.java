import java.util.Random;

public class Tlotto {
    public static void main(String[] args) {
        Random rd = new Random();
        int[] lotto = new int[6];
        for (int i = 0; i < 6; i++) {
            lotto[i] = rd.nextInt(45)+1;
            for (int j = 0; j < i; j++)
                {if (lotto[i]==lotto[j]) {i--;}}}
        for (int i = 0; i < lotto.length; i++)
            {System.out.println(lotto[i]);}
    }
}
