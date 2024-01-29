package com.edu.work;

import java.util.Arrays;
/*
 * 정수 10진수는 %d를 이용해서 표현한다.
 * %3d.. 앞에 2갸의 공간이 생긴다 ()()3
 * %03d 앞에 2개의 00이 생성 : 003
 */

public class ZigZagTest2 {

	public static void main(String[] args) {
		int[][] intArray = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 }, };

		for (int i = 0; i < intArray[0].length; i++) {

			if ((i % 2) == 0) {
				for (int j = 0; j < intArray.length; j++) {
					System.out.print(intArray[j][i] + " ");
				}
				System.out.println();
			} else if ((i % 2) != 0) {
				for (int j = intArray.length - 1; j >= 0; j--) {
					System.out.print(intArray[j][i] + " ");
				}
				System.out.println();
			}

		}
	}

}
