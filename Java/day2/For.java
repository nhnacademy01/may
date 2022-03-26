public class For {
    public static void main(String[] args) {
        int n = 10;
        int sum = 0;
        for (int i = 1; i <= n;i++){
            sum += i;
        }
        System.out.printf("sum 1 to %d = %d", n, sum);
    }
}
