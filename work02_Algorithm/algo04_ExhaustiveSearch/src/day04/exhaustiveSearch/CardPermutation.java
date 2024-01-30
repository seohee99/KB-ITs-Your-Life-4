package day04.exhaustiveSearch;
// n개의 정수에서 k개를 선택(중복 X)
public class CardPermutation {
	static boolean[] v;
	static int[] ans;
	static int K = 5, N = 3, cnt = 0; // K개 수에서 N개 선택
	public static void main(String[] args) {
		
		
		v = new boolean[K+1];
		ans = new int[N];
		
		// 항상 가장 위의 함수를 호출하면 됨
		dfs(0);
		System.out.println(cnt);
	}
	
	public static void dfs(int n) {
		// [0] 종료 조건(n 관련) 확인 후 정답 처리
		if (n == N) {
			// 정답에 관련된 처리 진행
			for (int i : ans) {
				System.out.print(i + " ");
			}
			System.out.println();
			cnt++;
			return;
		}
		
		// [1] 하부 단계 호출
		for (int j=1;j<=K; j++) {
			//중복 체크 후 사용하지 않았다면 선택
			if (v[j]) continue;
			
			v[j] = true;
			ans[n] = j;
			dfs(n+1);
			v[j] = false;
		}
		
	}

}
