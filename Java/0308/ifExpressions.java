class function {
    public void ifEXpre() {

        int month = 3;
        boolean isSpring = ifex2.isSpring(month);

        if (isSpring) ;
        if (isSpring) System.out.println("It's warm");
        if (isSpring)
            System.out.println("The snow melts");
        if (isSpring) {
            System.out.println("Flowers bloom");
        }
        if (!isSpring) {
            System.out.println("Not spring");
        }
    }

    public void ifVar() {
        int score = 95;
        int x = 6;
        char ch = 'A';
        String str = "I am Home";
        if (score >= 90 && score <= 100)
            System.out.println("A");
        if (score < 0 || score > 100)
            System.out.println("Not a score");
        if (x % 3 == 0 && x % 2 == 0)
            System.out.println("3의 배수면서 2의 배수");
        if (ch >= 'A' && ch <= 'Z')
            System.out.println("알파벳 대문자");
        if (str.equals("I am Home"))
            System.out.println("I am Home");
        if (toString().startsWith("I am"))
            System.out.println("I am ?");
    }
    public void ifelse() {
        int score = 90;
        if (score >= 0 && score <= 100) {
            System.out.println("It's a score");
        } else {
            System.out.println("Not a score");
        }
        if (score >= 0 && score <= 100) System.out.println("It's a score");
        else System.out.println("Not a score");

        if (score >= 0 && score <= 100) {
            System.out.println("It's a score");
        } else {
            System.out.println("Not a score");
        }

    }
}



public class ifExpressions {
    public static void main(String[] args) {
        function fn = new function();
        fn.ifEXpre();
        fn.ifVar();
        fn.ifelse();
    }
}