package day04.exhaustiveSearch;

import java.util.Scanner;

public class B2961 {
	
	static int ans, N, S, B;
	static int[][] arr; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N][2];
		
		// 배열 초기화 ({{S1,B1}, {S2,B2}..})
		for (int i=0;i<N;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		ans = 1000000000; // 무조건 갱신될 수 있는 최악의 값으로 초기화(문제에 주어져있음)
		dfs(0, 1, 0);
		System.out.println(ans);

	}

	private static void dfs(int n, int s, int b) {
		// 종료조건 : 정답처리
		if(n == N) {
			// 재료가 하나 이상이고 맛의 차이가 최소면 갱신
			if(b > 0 && ans > Math.abs(s-b)) {
				ans = Math.abs(s-b);
			}
			return;
		}
		
		// 하부 호출
		dfs(n+1, s*arr[n][0], b+arr[n][1]); // 선택한다
		dfs(n+1, S, B); // 선택안한다
	}

}
