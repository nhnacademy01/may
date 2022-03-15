package day7.exceotion;

public class Ex5 {
    public static void main(String[] args) {
        Money money = new Money(- 100L, "WON");
    }

}

class Money {
    long amount;
    String currency;

    public Money(long amount, String currency) throws IllegalArgumentException {
        if (amount < 0L) {
            throw new IllegalArgumentException("Money is not negative." + amount);
        }
        this.amount = amount;
        this.currency= currency;
    }
}