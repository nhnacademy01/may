package day9.class2;

public class TicToc {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                System.out.print("Tick ");
            } else {
                System.out.print("Tock ");
            }
            try {
                Thread.sleep(1000);     // 스레드가 1초 동안 잠들어요
            } catch (InterruptedException e) {
            }
        }
    }
}