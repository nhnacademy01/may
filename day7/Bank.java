//package day6.HomeWork;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//class BankShell {
//    public static void main(String[] args) {
//        Bank bank = new Bank();
//        //계좌발급 받기 (5개)
//        Account InfoAccount = accountInfo();
//
//
//    }
//
//    private static Account accountInfo() {
//        Scanner sc = new Scanner(System.in);
//        Account account = new Account();
//        int addAccount=0; //추가로 계좌 정보 입력 (0: 입력, 1: 중지)
//        System.out.println("NHN은행에 오신걸 환영합니다. /n 계좌 정보를 입력해주세요.");
//        while (addAccount==0){
//            System.out.println("예금주를 입력하세요.");
//            String tmpName = sc.next();
//            System.out.println("입금할 돈을 입력하세요.");
//            int tmpMoney = sc.nextInt();
//            System.out.println("화폐의 단위를 입력하세요. (WON, DOLLAR");
//            String moneyUnit = sc.next();
//            System.out.println("이율을 입력하세요.");
//            int tmpRate = sc.nextInt();
//
//            System.out.println("추가 개설을 하시겠습니까? (0: 입력, 1: 중지)");
//            addAccount = sc.nextInt();
//        }
//    }
//}
//
//public class Bank {
//    List<Account> accounts = new ArrayList<>();
//
//    //계좌개설하는 메소드
//    Account openAccount(Customer customer, Money initMoney) {
//
//    }
//
//    //모든 계좌 순회하면서 이자 지급
//    public void payInterestOnAllAccounts() {
//        for (Account account : accounts) {
//            account.payInterest();
//        }
//    }
//}
//
