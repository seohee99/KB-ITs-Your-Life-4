package day03.sorting;

import java.util.Arrays;
import java.util.Scanner;

// 삼중 for 문으로 다시 ㄱㄱ
public class J1158 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		int cnt = 0;
		// 초기화
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 1; i < n; i++) {
			int value = arr[i];
			int idx = 0;
			boolean insert = false;
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					idx = j;
					insert = true;
					break;
				}
			}
			if (insert == true) {
				for (int k = i; k > idx; k--) {
					arr[k] = arr[k - 1];
					cnt++;
				}
				arr[idx] = value;

			}

		}
		System.out.println("cnt : " + cnt);
	}

}
