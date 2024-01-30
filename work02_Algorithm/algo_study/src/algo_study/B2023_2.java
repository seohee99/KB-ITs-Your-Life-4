package algo_study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B2023_2 {
	static ArrayList<Integer> result;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N자리수

		result = new ArrayList<>();

		dfs(0, 0);
		Collections.sort(result);
		System.out.println(result);

	}

	public static void dfs(int num, int n) {
		if(n == N) {
			if(isPrime(num)) {
				result.add(num);
				return;
			}
				
		}
		for(int i=1; i<=9; i++) {
			int nn = i + num * 10;
			if (isPrime(nn)) {
				dfs(nn ,n+1);
			}
		}
		
	}

	// 소수 구하기 : N 보다 작은 자연수들로 모두 나눠본다
	// 1과 자신을 제외한 다른 수을 약수로 가지고 있다면 소수 X
	public static boolean isPrime(int n) {

		if (n == 1) return false;
		if (n == 2) return true;
		
		for (int i = 2; i < n; i++) {
			if ((n % i) == 0) {
				return false;
			}
		}
		return true;
	}

}
