import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Tdice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("참가자는 수를 입력하세요.");
        int pcnt = Integer.parseInt(sc.next());
        System.out.println("주사위 갯수를 입력하세요.");
        int dcnt = Integer.parseInt(sc.next());
        System.out.println("특수 룰을 추가하겠습니까? (yes, no)");
        String opt = sc.next();
        int winner = diceGame(pcnt, dcnt, opt);
        System.out.println("승자는 "+winner+"번째 사용자입니다.");

    }
    static int diceGame(int cnt1, int cnt2, String opt) {
        int[] score = new int[cnt1];
        for (int i = 0; i < cnt1; i++) {
            score[i] = dicescore(cnt2);
        }
        int mnum = maxscore(score);
        return mnum;
    }
    static int dicescore(int count){
        Random rd = new Random();
        int dscore=0;
        for (int i = 0; i < count; i++) {
            dscore += rd.nextInt(6);
        }
        return dscore;
    }
    static int maxscore(int[] array){
        int max = array[0];
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if(max<array[i]){
                max=array[i];
                num = i;
            }
        }
        return num;
    }
}
