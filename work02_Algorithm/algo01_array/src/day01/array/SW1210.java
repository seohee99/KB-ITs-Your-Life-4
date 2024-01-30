package day01.array;

import java.util.Arrays;
import java.util.Scanner;

public class SW1210 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 배열 초기화
		int[][] arr = new int[100][100];

		for (int t = 1; t <= 10; t++) {
			int tc = sc.nextInt();

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			boolean[][] visited = new boolean[100][100];
			// 방향 벡터
			int[] dy = { 1, -1 };
			int x = 98;
			// 시작 위치 찾기
			int idx = 0;
			for (int i = 0; i < 100; i++) {
				if (arr[99][i] == 2)
					idx = i;
			}
			int y = idx;
			// 사다리 시작
			while (true) {
				if ((y - 1 >= 0 && y - 1 < 100) && arr[x][y - 1] == 1 && visited[x][y - 1] == false) {
					visited[x][y - 1] = true;
					y = y - 1;

				} else if ((y + 1 >= 0 && y + 1 < 100) && arr[x][y + 1] == 1 && visited[x][y + 1] == false) {
					visited[x][y + 1] = true;
					y = y + 1;
				} else {

					visited[x - 1][y] = true;
					x -= 1;
				}
				if (x == 0) {
					System.out.println("#"+tc + " " + y);
					break;
				}
			}
		}
	}

}
