package algo_study;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int R, C, N;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("start");
		R = sc.nextInt();
		C = sc.nextInt();
		N = sc.nextInt();

		// 입력 초기화
		arr = new int[R][C];
		for (int i = 0; i < R; i++) {
			String[] temp = sc.next().split("");
			for (int j = 0; j < C; j++) {
				if (temp[j].equals("."))
					arr[i][j] = 0; // .이면 폭탄 없는 0, O이면 폭탄 설치된 지 1초를 의미하는 1로 초기화!
				else
					arr[i][j] = 1;
			}
		}
		
		// 봄버맨 활동 스따뜨
		for (int i = 2; i <= N; i++) {
			System.out.println(i);

			System.out.println(i+"초 후");
			nextTime();
			System.out.println(Arrays.deepToString(arr));
			
			
			if ((i % 2) == 0) {
				System.out.println("봄버맨 폭탄 놔용~");
				bombInstall();
				System.out.println(Arrays.deepToString(arr));
			} 
			System.out.println("폭탄 터져용");
			check();
			System.out.println(Arrays.deepToString(arr));
			
		}
		
		// 정답 출력
		for (int i = 0; i < R; i++) {
			String temp = "";
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 0)
					temp += ".";
				else
					temp += "O";

			}
			System.out.println(temp);
		}

	}

	public static void bombInstall() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
				}

			}
		}
	}

	public static void nextTime() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] != 0) {
					arr[i][j] += 1;
				}
			}
		}
	}

	public static void check() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 3) {
					if (i + 1 >= 0 && i + 1 < R && j >= 0 && j < C && arr[i + 1][j] != 3) {
						arr[i + 1][j] = 0;
					}
					if (i - 1 >= 0 && i - 1 < R && j >= 0 && j < C && arr[i - 1][j] != 3) {
						arr[i - 1][j] = 0;
					}
					if (i >= 0 && i < R && j + 1 >= 0 && j + 1 < C && arr[i][j + 1] != 3) {
						arr[i][j + 1] = 0;
					}
					if (i >= 0 && i < R && j - 1 >= 0 && j - 1 < C && arr[i][j - 1] != 3) {
						arr[i][j - 1] = 0;
					}
				}

			}

		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 3)
					arr[i][j] = 0;
			}
		}

	}

}