package com.edu.work;

public class ZigZagTest1 {

	public static void main(String[] args) {
		int[][] intArray = 
			{ 
					{ 1, 2, 3, 4, 5 }, 
					{ 6, 7, 8, 9, 10 }, 
					{ 11, 12, 13, 14, 15 }, 
					{ 16, 17, 18, 19, 20 }, 
					};

		for (int i = 0; i < intArray.length; i++) {
			
			if ((i % 2) == 0) {
				for (int j = 0; j < intArray[i].length; j++) {
					System.out.print(intArray[i][j] + " ");
				}
				System.out.println();
			} else if ((i % 2) != 0) {
				for (int j = intArray[i].length - 1; j >= 0; j--) {
					System.out.print(intArray[i][j]+ " ");
				}
				System.out.println();
			}

		}

	}

}
