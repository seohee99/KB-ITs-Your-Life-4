package day01.array;

import java.util.Arrays;
import java.util.Scanner;

public class B2567 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[102][102];

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			// 색종이 시작 위치
			int a = sc.nextInt();
			int b = sc.nextInt();

			// 색종이 붙이기
			for (int x = a; x < a + 10; x++) {
				for (int y = b; y < b + 10; y++) {
					arr[x][y] = 1;
				}
			}
		}
		int result = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (arr[i][j] == 1) {
					// 4방향 상/하/좌/우 0의 개수

					if (arr[i-1][j] == 0) result ++;
					if (arr[i][j-1] == 0) result ++;
					if (arr[i + 1][j] == 0) result ++;
					if (arr[i][j + 1] == 0) result ++;

				}
			}
		}
		System.out.println(result);
	}

}
