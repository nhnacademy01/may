package com.nhnacademy.exam.question2;

public class Answer2 {

	public static void main(String[] args) {
		System.out.println(Sigma.calc(1, 10, 1));
		System.out.println(Pi.calc(1, 10, 1));
	}
}

interface BinaryOp {
	int apply2(int cnt1, int cnt2);
}

class Adder2 implements BinaryOp {
	@Override
	public int apply2(int cnt1, int cnt2) {
		return cnt1 + cnt2;
	}
}

class Multiplier2 implements BinaryOp {
	@Override
	public int apply2(int cnt1, int cnt2) {
		return cnt1 * cnt2;
	}
}

class Calculator2 {
	public static int accumulate(BinaryOp binder, int init, int begin, int end, int step) {
		int result = init;
		for (int next = begin; next <= end; next += step) {
			result = binder.apply2(result, next);
		}
		return result;
	}
}

class Sigma {
	public static int calc (int begin, int end, int step) {
		return Calculator2.accumulate(new Adder2(), 0, begin, end, step);
	}
}

class Pi {
	public static int calc (int begin, int end, int step) {
		return Calculator2.accumulate(new Multiplier2(), 1, begin, end, step);
	}
}