package day6.HomeWork;

public class Money {
    private int amount;
    private Currency currency;

    public Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int add(Money money) {
        this.amount += money.getAmount();
        return amount;
    }

    public int sub(Money money) {
        this.amount -= money.getAmount();
        return amount;
    }

    public int getAmount() {
        return amount;
    }

    public enum Currency {
        WON, DOLLAR
    }

    public static boolean contains(String currencyStr) {
        for (Currency currency : Currency.values()) {
            if (currency.name().equals(currencyStr)) {
                return true;
            }
        }
        return false;
    }


}
