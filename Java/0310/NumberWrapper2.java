public class NumberWrapper2 {
    int value;

    public static void main(String[] args) {
        NumberWrapper n = new NumberWrapper();
        n.value = 1;
        NumberWrapper n2 = copy(n);
        changeTo(n,2);
        System.out.println("n.value= "+n.value);
        System.out.println("n2.value= "+n2.value);

    }
        static NumberWrapper copy(NumberWrapper source) {
        return source;
        }
        static void changeTo(NumberWrapper n, int newValue){
        n.value = newValue;
        }

}
