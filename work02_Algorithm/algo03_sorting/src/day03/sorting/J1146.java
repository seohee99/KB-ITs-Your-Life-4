package day03.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class J1146 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		for (int i = 0; i < n - 1; i++) {
			int temp = arr[i];
			int min_idx = i;

			for (int j = i + 1; j < n; j++) {
				if (arr[min_idx] > arr[j]) {
					min_idx = j;
				}
			}
			arr[i] = arr[min_idx];
			arr[min_idx] = temp;
			for (int k : arr)
				System.out.print(k + " ");

			System.out.println();

		}

	}

}
