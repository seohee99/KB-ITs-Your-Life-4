package algo_study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B11123 {
	
	static int[][] arr;
	static boolean[][] visited;
	static int H, W;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int testCase = 1; testCase <= T; testCase++) {
			H = sc.nextInt();
			W = sc.nextInt();
			//입력 초기화 (#(양) : 1, .(풀떼기) : 0)
			arr = new int[H][W];
			visited = new boolean[H][W];
			
			for (int i=0; i < H; i++) {
				String[] temp = sc.next().split("");
				for (int j=0; j<W; j++) {
					
					if(temp[j].equals("#")) arr[i][j] = 1;
					else arr[i][j] = 0;
				}
			}
			int cnt = 0;
			for (int i=0; i < H; i++) {
				for (int j=0; j<W; j++) {
					if(arr[i][j] == 1 && visited[i][j] == false) {
						bfs(new Pos(i,j)); // 모든 배열을 돌면서 bfs 수행
						cnt ++;
					}
					
				}
			}
			System.out.println(cnt);
		}
		
	}

	public static void bfs(Pos s) {
		Queue<Pos> q = new LinkedList<>();
		visited[s.i][s.j] = true;
		
		q.add(s);
		
		int[] di = {0,1,0,-1};
		int[] dj = {1,0,-1,0};
		
		while(!q.isEmpty()) {
			Pos c = q.poll();
			
			for(int d=0; d<4; d++) {
				int ni = c.i + di[d];
				int nj = c.j + dj[d];
				
				if(ni >=0 && ni < H && nj >= 0 && nj < W && !visited[ni][nj] && arr[ni][nj] == 1) {
					visited[ni][nj] = true;
					q.add(new Pos(ni,nj));
				}
			}
			
		}
	}
}
class Pos {
	public int i, j;

	Pos(int i, int j) {
		this.i = i;
		this.j = j;
	}
}