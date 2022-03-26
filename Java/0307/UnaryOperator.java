public class UnaryOperator {
    public static void main(String[] args) {
        UnaryOperator op = new UnaryOperator();
        op.unary1();
        op.unary2();
    }

    private void unary1() {
        int i = -10;
        int result = +i;
        System.out.println(result);
        result = -i;
        System.out.println(result);
    }
    public  void unary2() {
        int i = 1;
        System.out.println(i++);
        System.out.println(i);
        System.out.println(++i);
        System.out.println("-----");
        System.out.println(--i);
        System.out.println(i);
        System.out.println(i--);
        System.out.println(i);
    }
}
