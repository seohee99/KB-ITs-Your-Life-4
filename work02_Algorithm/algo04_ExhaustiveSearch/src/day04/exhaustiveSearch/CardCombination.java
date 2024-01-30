package day04.exhaustiveSearch;

import java.util.Arrays;

public class CardCombination {
	static boolean[] v;
	static int[] ans;
	static int K = 4, N = 3, count = 0; // K개 수에서 중복 X N개 순서대로 선택
	static int idx;
	public static void main(String[] args) {
		ans = new int[K];
		
		dfs(0,0,0);
		System.out.println(count);
	}
	public static void dfs(int n, int cnt, int idx) {
		// 종료조건(n관련) 확인 후 정답 처리
		if( n == K) { 
			if (cnt == N) { // 선택한 개수가 N개면
				for(int t:ans) System.out.print(t + " ");
				System.out.println();
				count ++;
			}
			return;
		}
		ans[idx] = n+1;
		dfs(n+1, cnt+1,idx+1); // 선택하는 경우
		dfs(n+1, cnt,idx); // 선택하지 않는 경우
	}

}
