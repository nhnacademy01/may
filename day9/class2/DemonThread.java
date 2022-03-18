package day9.class2;

public class DemonThread extends Thread {
    public static void main(String[] args) {
        DemonThread t = new DemonThread();
//        t.setDaemon(false);   // 데몬 스레드가 아니면 어떻게 작동될까?
        t.start();
    }

    public DemonThread() {
        super();
        this.setDaemon(true);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {

        }
    }
}

