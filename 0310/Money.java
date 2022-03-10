public class Money {
    long amount;
    String currency;

    public  Money(){
        this(0L);
    }
    public  Money(long amount){
        this(amount, "WON");
    }
    public Money(long amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }
    public static void main(String[] args) {
        Money amt1 = new Money(1_000, "WON");
        Money amt2 = new Money();
        amt2.amount = 2_000;
        amt2.currency = "DOLLAR";

        System.out.printf("amt1 = %d %s%n", amt1.amount, amt1.currency);
        System.out.printf("amt2 = %d %s%n", amt2.amount, amt2.currency);
    }
}
