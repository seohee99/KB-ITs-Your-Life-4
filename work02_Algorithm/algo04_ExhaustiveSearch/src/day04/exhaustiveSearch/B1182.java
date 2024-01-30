package day04.exhaustiveSearch;

import java.util.Scanner;

public class B1182 {
	static int N, S;
	static int[] arr;


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		dfs(0,0,0);
//	System.out.println(cnt);
	}


	public static void dfs(int n, int cnt, int sum) {
		// 종료 조건 : 합을 만족하면 종료 (합보다 크면..?)
		if(n == N) {
			if(sum == S) {
				cnt ++;
				return;
			}
		}
		
		
		for(int i=0;i<N;i++ ) {
			sum += arr[i];
			dfs(n+1, cnt, sum);
		}
		
	}

}
