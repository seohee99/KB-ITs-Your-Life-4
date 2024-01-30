package day04.exhaustiveSearch;

import java.util.Arrays;
import java.util.Scanner;

public class B15649 {
	static int N, M;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		visited = new boolean[N + 1];
		arr = new int[M];

		dfs(0);
	}

	private static void dfs(int n) {
		// 종료조건
		if (n == M) {
			for (int j : arr) {
				System.out.print(j + " ");
			}
			System.out.println();// m개 다 뽑으면 종료
			return;
		}
		// 하부 호출
		for (int i = 0; i <= N; i++) {
			if (visited[i] == true) continue; // 이미 사용했으면 넘어감!!!
			visited[i] = true;
			arr[n] = i;			
			dfs(n + 1); // 다음으로!
			visited[i] = false;
		}

	}

}
