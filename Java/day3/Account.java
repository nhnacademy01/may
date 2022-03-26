public class Account {
    public static void main(String[] args) {
        Account nhnAccount = new Account();
        nhnAccount.deposit(1_000L);
        nhnAccount.withdraw(500L);
        System.out.println("amount= "+nhnAccount.getAmount());
    }

    public long getAmount() {
        return this.amount;
    }

    private void withdraw(long depositAmt) {
        this.amount += depositAmt;
    }

    private long amount = 0L;

    public void deposit(long depositAmt){
        this.amount += depositAmt;
    }
}
