public class SwapAdvanced {
    public static void main(String[] args) {
        int a = 10, b = 20;
        // int tmp; 제거
        System.out.println("a: "+a+ ", b: "+b);
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println("After swap. a: "+a+", b:"+b);
    }
}
