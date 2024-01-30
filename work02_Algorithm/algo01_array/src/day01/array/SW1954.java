package day01.array;

import java.util.Arrays;
import java.util.Scanner;

//달팽이숫자
public class SW1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			arr[0][0] = 1;

			// 방향벡터
			int[] dx = { 0, 1, 0, -1 };
			int[] dy = { 1, 0, -1, 0 };
			int d = 0;

			int x = 0;
			int y = 0;
			int cnt = 1;

			while (cnt < Math.pow(n, 2)) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				// 범위 체크 먼저!!!!
				if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 0) {
					cnt++;
					x = nx;
					y = ny;
					arr[x][y] = cnt;
				} else {
					d = (d + 1) % 4;
				}
			}

			System.out.println("#" + test_case);
			for (int i = 0; i < n;i++) {
				for(int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
