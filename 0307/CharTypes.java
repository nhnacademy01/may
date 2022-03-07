public class CharTypes {
    public static void main(String[] args) {
        char a = 'A';
        char b = 65;
        char c = '\u0041';

        char d = 'a';
        char f = '홍';
        char h = '\u2374';
        char j = 65_535;


        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        System.out.println("c = " + d);
        System.out.println("c = " + f);
        System.out.println("c = " + h);
        System.out.println("c = " + j);

    }
}
