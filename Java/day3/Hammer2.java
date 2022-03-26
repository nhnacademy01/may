public class Hammer2 {
    String model;
    int number;
    static  int weight = 2_000;

    public static void main(String[] args) {
        System.out.println("weight="+Hammer.weight);

        Hammer h1 = new Hammer();
        h1.model = "h1";
        h1.number = 1;

        Hammer h2 = new Hammer();
        h2.model = "h2";
        h2.number=10;

        printHammmer(h1, "h1");
        printHammmer(h2, "h2");

        h2.number=11;
        h2.weight=1_000;

        printHammmer(h1, "h1");
        printHammmer(h2, "h2");

    }

    private static void printHammmer(Hammer h1, String name) {
        System.out.println(name+":"+h1.model+","+h1.number+","+h1.weight);
    }
}

