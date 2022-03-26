public class forasci {
    public static void main(String[] args) {
        for (int i = 65; i < 92; i++) {
            System.out.printf(String.valueOf(i));
        }
        for (int i = 0; i<4; i++) {
            System.out.println("********");
        }
    }
}

class Gugudan{
    void main(String[] args) {
        for (int i =2; i<=9; i++) {
            for (int j=1; j<=9; j++) {
                System.out.printf("%d * %d = %2d%n", i, j, i*j);
            }
            System.out.println("----------------");
        }
    }
}
