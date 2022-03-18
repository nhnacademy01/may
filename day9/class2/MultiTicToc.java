package day9.class2;

public class MultiTicToc {

    public static void main(String[] args) {
        Thread tick = new Thread(new Tick());
        Thread tock = new Thread(new Tock());
        tick.start();
        tock.start();
    }

    static class Tick implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.print("Tick ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    static class Tock implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            for (int i = 0; i < 5; i++) {
                System.out.print("Tock ");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
