package day7.oop1;

import java.math.BigInteger;

public class BigFactorial {
    public static void main(String[] args) {
        BigFactorial f = new BigFactorial();
        BigInteger result = f.factorial(BigInteger.valueOf(30)); //long
        System.out.println("factorial(30): " + result);
    }

    private BigInteger factorial(BigInteger value) {
        if (value.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;   //0이되었을때 1 반환
        }
        return value.multiply(factorial(value.subtract(BigInteger.ONE)));
    }       //재귀함수로 -1씩 뺀 수를 계속 곱하여 팩토리얼 함수 구현
}

