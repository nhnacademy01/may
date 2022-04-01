package com.nhnacademy.exam.question2;

public class Answer1 {
	public static void main(String[] args) {
		System.out.println(Calculator.sigma(1, 10, 1));
		System.out.println(Calculator.pi(1, 10, 1));
	}
}

class Calculator {
	public static int accumulate(Adder binder, int begin, int end, int step) {
		int result = 0;
		for (int next = begin; next <= end; next += step) {
			result = binder.apply(result, next);
		}
		return result;
	}

	public static int accumulate(Multiplier binder, int begin, int end, int step) {
		int result = 1;
		for (int next = begin; next <= end; next += step) {
			result = binder.apply(result, next);
		}
		return result;
	}

	public static int sigma(int begin, int end, int step) {
		return accumulate(new Adder(), begin, end, step);
	}

	public static int pi(int begin, int end, int step) {
		return accumulate(new Multiplier(), begin, end, step);
	}
}

class Adder {
	int apply(int cnt1, int cnt2) {
		return cnt1 + cnt2;
	}
}

class Multiplier {
	int apply(int cnt1, int cnt2) {
		return cnt1 * cnt2;
	}
}

