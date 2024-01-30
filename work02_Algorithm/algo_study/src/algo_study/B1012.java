package algo_study;

import java.util.Scanner;

public class B1012 {
	static int N,M;
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case <= T; test_case ++) {
			N = sc.nextInt();
			M = sc.nextInt();
			int K = sc.nextInt();
			
			// 배열 초기화
			arr = new int[N][M];
			for(int i=0; i<K;i++) {
				arr[sc.nextInt()][sc.nextInt()] = 1;
			}
			visited =  new boolean[N][M];
			int cnt = 0;
			// 전체를 돌면서 같은 땅이면 cnt +1
			for(int i=0; i<N;i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j] == 1 && visited[i][j] == false) {
						dfs(i,j);
						cnt++;
					}					
				}
			}
			System.out.println(cnt);
		}

	}

	public static void dfs(int x, int y) {
		// 첫방문
		
		visited[x][y] = true;
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		for(int d=0; d<4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx >=0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 1 && !visited[nx][ny]) {
				dfs(nx,ny);
			}
		}
		
		
	}

}