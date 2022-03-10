public class Money2 {
    long amount = 0L;
    String currency = "WON";
    static  int count = 0;

    static  {
        System.out.println("클래스 초기화");
        count++;
    }
    {
        System.out.println("인스턴스 초기화");
        amount=10L;
        currency="DOLLAR";
        count++;
    }
    public Money2(){
        System.out.println("생성자");
        amount=1L;
        currency="GOLD";
        count++;
    }

    public static void main(String[] args) {
        System.out.println("main 실행");
        Money2 money = new Money2();
        System.out.printf("money = %d %s%n", money.amount, money.currency);
        System.out.printf("calling count = %d%n", count);
    }
}

class MoneyEX{
    public static void main(String[] args) {
        System.out.println("main 실행");
        Money2 money = new Money2();
        System.out.printf("money = %d %s%n", money.amount, money.currency);
        System.out.printf("calling count = %d%n", Money2.count);
    }
}