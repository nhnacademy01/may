//package day6.HomeWork;
//
//import test.UnitCheck;
//
//import java.util.ArrayList;
//
//
//public class Account {
//    private Customer customer;
//    private Money balance; // 금액
//    private float interestRate; //이율
//
//    public Account(Customer customer, Money balance, float interestRate) {
//        this.customer = customer;
//        this.balance = balance;
//        this.interestRate = interestRate;
//    }
//
//
//    // 입금
//    public Money deposit(Money amount) {
//        // 제약 조건
//        this.balance = this.balance.add(amount);
//        return this.balance;
//    }
//
//    // 출금
//    public Money withdrawal(Money amount) {
//        // 제약 조건
//        this.balance = this.balance.sub(amount);
//        return this.balance;
//    }
//
//    // 이자 지급
//    Money payInterest(Money amount) {
//        Money interest = cacluateInterest();
//        this.balance = this.balance.add(interest);
//        return this.balance;
//    }
//
//    // 이자 계산
//    private Money cacluateInterest() {
//        // TODO
//    }
//
//}
//
//
//
//
//
//
