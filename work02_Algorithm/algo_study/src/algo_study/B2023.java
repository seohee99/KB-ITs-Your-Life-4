package algo_study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B2023 {
	static ArrayList<Integer> result;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // N자리수
		
		
		int start = (int) Math.pow(10, N-1);
		int end = (int) Math.pow(10, N) - 1;
		result = new ArrayList<>();
		
		for(int i=start; i<=end; i++) {
			split(i);
		}
		
		for(int i:result) System.out.println(i);
		
		
	}
	
	
	// 숫자를 자리수마다 쪼개서 isPrime 인자로 넣어 호출!
	public static void split(int n) {
		int[] temp = new int[N];
		
		int d = (int) Math.pow(10, N-1);
		for(int i=0; i<N; i++) {
			
			temp[i] = n / d;
			d /= 10;
			
		}
		
		int cnt = 0;
		for(int i: temp) {
			if(isPrime(i)) cnt ++;
		}
		if (cnt == N) {
			result.add(n);
		}
		
	}



	// 소수 구하기 : N 보다 작은 자연수들로 모두 나눠본다
	// 1과 자신을 제외한 다른 수을 약수로 가지고 있다면 소수 X
	public static boolean isPrime(int n) {
		
		boolean flag = false;
		if(n < 2) return false;
		if(n == 2) return true;
		for(int i = 2; i < n; i++) {
			if((n % i) == 0) {
				flag = true;
				return false;
			}
		}
		return true;
	}
	

}
