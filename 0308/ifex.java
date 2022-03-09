public class ifex {
    public static void main(String[] args) {
        int month =8;
        if (month>=3) {
            System.out.println("Greather than or equal 3");
        }
        if (month >= 3 && month <=5)  {
            System.out.println("flowers bloom");
        }
    }
}

class ifex2 {
    public static void main(String[] args) {
        int month =4;
        if (isSpring2(month)) {
            System.out.println("Greather than or equal 3");
        }
        if (isSpring(month)) {
            System.out.println("flowers bloom");
        }
    }
        static boolean isSpring(int month) {
            return month >= 3 && month <=5;
    }
        static boolean isSpring2(int month) {
            return month >= 3;
        }
}