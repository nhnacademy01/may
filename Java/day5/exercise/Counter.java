package day5.exercise;

import java.util.ArrayList;

public class Counter {

    public int calculator(ArrayList<CustomerWallet.Coupon> allCoupons, int totalPrice) {
        int finalPrice = 0;
        for (CustomerWallet.Coupon tmpCoupons : allCoupons) {
            if (tmpCoupons.couponType() == '*') {
                finalPrice = (int) (totalPrice * tmpCoupons.saleRate());
            } else if (tmpCoupons.couponType() == '-') {
                finalPrice = finalPrice - ((int) tmpCoupons.saleRate());
            }
        }
        return finalPrice;
    }
}
