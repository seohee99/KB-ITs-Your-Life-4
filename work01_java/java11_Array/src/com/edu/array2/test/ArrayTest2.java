package com.edu.array2.test;

public class ArrayTest2 {

	public static void main(String[] args) {
		int[ ] member = {1, 2, 3, 4 ,5};
		member = new int[8]; // 배열은 resize가 안됨, 새로 만드는 순간 원래 배열은 GC의 대상이 됨 
		member[5] = 6;		
		member[6] = 7;		
		member[7] = 8;
		
		// 0,0,0,0,0,6,7,8
		for (int v : member) System.out.println(v);

	}

}
