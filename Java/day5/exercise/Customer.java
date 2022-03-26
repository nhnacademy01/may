package day5.exercise;


import java.util.ArrayList;

public class Customer {
    // 고객의 구매 목록
    private final BuyList buyList;
    // 고객의 장바구니
    private Basket basket;

    //고객지갑 객체 생성
    CustomerWallet customerWallet = new CustomerWallet();

    //객체 생성자 : 구매리스트를 가진 고객 객체
    public Customer(BuyList buyList) {
        this.buyList = buyList;
        //지갑객체에 돈, 쿠폰 수동으로 넣어주기 (나중에는 받아서 넣을수 있게 구현해도 된다.
        customerWallet.Plus(new CustomerWallet.Coupon('*', 0.9f), 20_000);
        customerWallet.Plus(new CustomerWallet.Coupon('-', 1_000), 20_000);
    }

    // 장바구니를 챙김
    public void bring(Basket basket) {
        this.basket = basket;
    }

    //객체로 식품매대 들어오면 고객의 구매리스트만큼 식품을 식품매대에서 장바구니에 담는다.
    public void pickFoods(FoodStand foodStand) {
        ArrayList<BuyList.Item> itemList = buyList.itemList();
        ArrayList<Food> foodLists = foodStand.foodLists();
        //buylist에 있는 식품들 foodstand에서 name으로 매칭시켜서 price 가져오기...
        int tmpPrice = 0;
        for (BuyList.Item tmpItem:itemList) {
            String tmpName = tmpItem.itemName();
            int tmpCount = tmpItem.itemCount();
            for (Food tmp:foodLists) {
                if (tmpName.equals(tmp.getName())) {
                    tmpPrice = tmp.getPrice();};}
            basket.add(new Food(tmpName, tmpCount * tmpPrice));
        }
    }

    //객체로 카운터 들어오면 고객의 장바구니를 계산하여 돈 지불한다.
    public void payTox(Counter counter) {
        int totalPrice = 0;
        ArrayList<Food> totalFoods = basket.foodLists();
        for (Food tmpFood:totalFoods) {
            totalPrice += tmpFood.getPrice();}

        ArrayList<CustomerWallet.Coupon> allCoupons = this.customerWallet.getCoupon();
        int allMoney = this.customerWallet.getMoney();

        int finalPrice = counter.calculator(allCoupons, totalPrice);

        System.out.println("총 가격은 "+totalPrice+"원 입니다.");
        System.out.println("할인 후 "+finalPrice+"원 입니다. 고맙습니다.");
        System.out.println("고객님 결제 후 잔액 : " + (allMoney - finalPrice));

    }

}

