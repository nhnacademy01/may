import java.util.Random;
import java.util.Scanner;

public class Trpsgame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int user;
        int comp;
        do {
            System.out.println("가위(1) 바위(2) 보(3): ");
            user = Integer.parseInt(sc.next());
            comp = rd.nextInt(3);
            presult(user, comp);
        } while (user == comp);}
    static void presult (int u, int c) {
        switch (u){
            case 1:
                System.out.println("당신은 가위(1)입니다.");
                break;
            case 2:
                System.out.println("당신은 바위(2)입니다.");
                break;
            case 3:
                System.out.println("당신은 보(3)입니다.");
                break;
        }
        switch (c){
            case 1:
                System.out.println("컴퓨터는 가위(1)입니다.");
                break;
            case 2:
                System.out.println("컴퓨터는 바위(2)입니다.");
                break;
            case 3:
                System.out.println("컴퓨터는 보(3)입니다.");
                break;
        }
        if (u==c){
            System.out.println("비겼습니다. 다시 합니다.");
        }
        else if (u>c){
            System.out.println("이겼습니다.");
        }
        else if (u<c){
            System.out.println("졌습니다.");
        }
        }
    }

