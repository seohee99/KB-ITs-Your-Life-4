package com.edu.array3.test;

public class TwoDimArrayTest {

	public static void main(String[] args) {
		
		// 2행 3열 배열
		int[ ][ ] twoArr = new int[2][3]; 
		
		System.out.println(twoArr.length); // row : 2
		System.out.println(twoArr[0].length); // col : 3
		System.out.println(twoArr[1].length); // col : 3
		
		for (int i = 0; i < twoArr.length; i++) {
			for(int j = 0; j < twoArr[0].length; j++) {
				System.out.print(twoArr[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("==================================");
		// 가변 길이 배열
		int[][] twoArr2 = new int[2][]; // 행만 먼저 만들어놓겠다
		System.out.println(twoArr2.length);
//		System.out.println(twoArr2[0].length); error
		twoArr2[0] = new int[3];
		twoArr2[1] = new int[6];
		
		System.out.println(twoArr2[0].length);
		System.out.println(twoArr2[1].length);
	}

}
