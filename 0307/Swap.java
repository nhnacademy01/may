public class Swap{
    public static void main(String[] args) {
        int a = 10, b =20;
        int tmp;
        System.out.println("a: "+ a + ", b: " + b);
        tmp = a;
        a=b;
        b=tmp;
        System.out.println("After swap. a: " + a + ", b: " +b);
    }
}
