package com.github.mahui53541.algorithms.c1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		
		int num=n*n;
		int pows[]=new int[n*n];//记录所有幂运算结果
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				pows[i*n+j]=(int) Math.pow(i+1, j+1);
			}
		}
		Arrays.sort(pows);
		int flag=1;
		for(int i=1;i<n*n;i++) {
			if(pows[i-1]==pows[i]) {
				flag++;
			}else if(flag>1){
				num+=flag*(flag-1);
				flag=1;
			}
		}
		if(flag>1) {
			num+=flag*(flag-1);
		}
		System.out.println(num%1000000007);
	}
}
