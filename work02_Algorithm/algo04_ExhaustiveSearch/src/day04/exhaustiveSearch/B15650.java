package day04.exhaustiveSearch;

import java.util.Scanner;

public class B15650 {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[M];
		// main 함수에서는 가장 상위 dfs만 호출
		// 0번 인덱스에 저장할 숫자를 선택, 시작 번호는 1
		dfs(0, 1);
	}

	private static void dfs(int n, int s) {
		// 종료조건
		if (n == M) {
			for (int j : arr) {
				System.out.print(j + " ");
			}
			System.out.println();// m개 다 뽑으면 종료
			return;
		}

		for (int i = s; i <= N; i++) {

			arr[n] = i; // 선택한 숫자 저장
			dfs(n + 1, i + 1); // 다음 숫자 선택하러 하부 호출

		}

	}

}
