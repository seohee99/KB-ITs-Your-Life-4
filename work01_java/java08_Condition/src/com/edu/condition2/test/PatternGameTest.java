package com.edu.condition2.test;

import java.util.Scanner;

public class PatternGameTest {
	
	public static void solve(int n){
		int first = n / 10;
		int second = n % 10;
		String result = "";
		
		if((first / 3) == 0) result += "@";
		if((second % 3) == 0) result += "@";
		
		if (result == "") System.out.println(n);
		else System.out.println(result);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input Number : ");
		int n = sc.nextInt();
		
		solve(n);

	}

}
