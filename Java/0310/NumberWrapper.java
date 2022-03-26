public class NumberWrapper {
    int value;

    public static void main(String[] args) {
        NumberWrapper n = new NumberWrapper();
        n.value = 1;
        changeTo(n.value, 2);
        System.out.println("change n.value="+n.value);
        changeTo(n, 2);
        System.out.println("change n = "+n.value);
    }
    static void changeTo(int value, int newValue) {
        value = newValue;
    }

    static void changeTo(NumberWrapper n, int newValue) {
        n.value = newValue;
    }
}
