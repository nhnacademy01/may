package day5.exercise;

import java.util.ArrayList;

public class CustomerWallet {
    // 고객 지갑 만들어서 돈, 쿠폰 저장
    int money;
    ArrayList<Coupon> couponList = new ArrayList<>();

    public void Plus(Coupon coupon, int money) {
        couponList.add(coupon);
        this.money = money;
    }

    public ArrayList<Coupon> getCoupon() {
        return couponList;
    }

    public int getMoney() {
        return money;
    }

    public static class Coupon {
        char type;
        float saleRate;

        public Coupon(char type, float saleRate) {
            this.type = type;
            this.saleRate = saleRate;
        }
        public char couponType() {
            return type;
        }

        public float saleRate() {
            return saleRate;
        }

    }
}