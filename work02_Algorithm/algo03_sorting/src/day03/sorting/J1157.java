package day03.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class J1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				int temp = arr[j];
				if (arr[j] > arr[j + 1]) {
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			for (int k : arr)
				System.out.print(k + " ");

			System.out.println();
		}

	}

}
