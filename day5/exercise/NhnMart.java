package day5.exercise;


import java.util.Scanner;

class NhnMartShell {
    public static void main(String[] args) {
        NhnMart mart = new NhnMart();

        //식품 매대 채우기
       mart.prepareMart();
        //구매리스트 받음
        BuyList buyList = inputBuyListFromShell();
        //구매리스트 가진 고객 객체 생성
        Customer minay = new Customer(buyList);
        // 장바구니를 챙긴다.
        minay.bring(mart.provideBasket());
        // 식품을 담는다.
        minay.pickFoods(mart.getFoodStand());
        // 카운터에서 계산한다.
        minay.payTox(mart.getCounter());
    }

    private static BuyList inputBuyListFromShell() {
        // Scanner에서 buyList 만들기
        Scanner sc = new Scanner(System.in);
        BuyList buyList = new BuyList();
        int buyAgain = 0;  //구매의사(계속 구매할건지?)
        System.out.println("NHN 마트에 오신 것을 환영합니다. 사고 싶은 물건을 골라주세요.");
        while (buyAgain == 0) {
            String foodName = sc.next();
            int foodCount = sc.nextInt();
            buyList.add(new BuyList.Item(foodName, foodCount));
            System.out.println("식품을 계속 구매하시겠습니까? (네:0, 아니요:1");
            buyAgain = sc.nextInt();
        }
        return buyList;  //고객에게 받은 전체 구매리스트 반환
    }
}

public class NhnMart {
    private final FoodStand foodStand = new FoodStand();

    public void prepareMart() {
        fillFoodStand();
    }

    private void fillFoodStand() {
        for (int i = 0; i < 2; i++) {
            foodStand.add(new Food("양파", 1_000));
        }
        for (int i = 0; i < 5; i++) {
            foodStand.add(new Food("계란(30개)", 2_000));
        }
        for (int i = 0; i < 10; i++) {
            foodStand.add(new Food("파", 500));
        }
        for (int i = 0; i < 20; i++) {
            foodStand.add(new Food("사과", 2_000));
        }
    }

    public Basket provideBasket() {
        return new Basket();
    }

    public FoodStand getFoodStand() {
         return new FoodStand();
    }

    public Counter getCounter() {
        return new Counter();
    }
}
