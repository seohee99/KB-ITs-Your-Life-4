package com.edu.array.test;
/*
 * Same Data Type의 서로 다른 값들을 하나로 묶을 수 있는데 이게 바로 Array라는 객체이다.
 * ::
 * Array는
 * 1) 선언 2) 생성 3)초기화
 */

public class BasicArrayTest2 {

	public static void main(String[] args) {
		
		//1 선언 + 2 생성
		int[ ] arr = new int[3];
		
		//3 초기화
		arr[0] = 11;
		arr[1] = 22;
		arr[2] = 33;
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		

	}

}
