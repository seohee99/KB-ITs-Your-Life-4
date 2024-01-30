package algo_study;

import java.util.ArrayList;
import java.util.Scanner;

public class B17352 {
	public static int N;
	public static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		p = new int[N+1];
		for (int i=0; i<N; i++) p[i]=i;
		
		for(int i=2; i<N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			union(a,b);
		}
		boolean flag = false;
		for(int i=1; i<=N; i++) {
			if (flag == true) break;
			for(int j=i+1;j<=N;j++) {
				if(findSet(i) != findSet(j)) {
					System.out.println(i + " " + j);
					flag = true;
					break;
				}
			}
		}

	}
	
	public static void union(int a, int b) {
		p[findSet(b)] = findSet(a);
		
	}

	public static int findSet(int n) {
		if(n == p[n]) return n;
		return p[n] = findSet(p[n]);
	}

}
