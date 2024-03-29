package com.edu.condition2.test;

import java.util.Scanner;

/*
 *  간단한 알고리즘을 푸는 테스트 코드의 구조
 */

public class CatchAMouseTest {
	
	public static void solve(int x, int y, int z) {
		int A = Math.abs(z - x);
		int B = Math.abs(z - y);
		
		if (A > B) System.out.println("CatB Catch!");
		else if (A < B ) System.out.println("CatA Catch!");
		else System.out.println("Mouse Escapes !!");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 순서대로 정수값을 입력 받자.
		System.out.println("값 입력 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		// 입력받은 값들을 가지고 알고리즘을 해결해야한다.
		// 메소드 안에서 알고리즘을 해결
		
		// solve(a, b, c); 일케만 하면 메모리에 아직 올라가지 않아서 빨간줄뜸 -> 객체 생성을 해야해
		solve(a, b, c); // 그치만 static으로 작성하면 객체 생성안해도 호출 가능임

	}

}
