package com.github.mahui53541.algorithms.c1;

public class TestPractise {

	public static void main(String[] args) {
		Stack<Integer> stack=new Stack<Integer>();
		int N=50;
		while(N>0) {
			stack.push(N%2);
			N/=2;
		}
		for(int d:stack) System.out.print(d);
	}

}
