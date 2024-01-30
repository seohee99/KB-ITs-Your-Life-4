package day01.array;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		int[] arr = {100, 200, 300, 400, 500};
		
		System.out.println("===1-1===");
		for (int i : arr) {
			if (i == 300) System.out.println(i);
		}
		System.out.println("===1-2===");
		int c = 0;
		for (int i : arr) {
			if (i == 400) {
				arr[c] = 999;
				System.out.println(Arrays.toString(arr));
			}
			c++;
		}
		System.out.println("===1-3===");
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));


	}

}
