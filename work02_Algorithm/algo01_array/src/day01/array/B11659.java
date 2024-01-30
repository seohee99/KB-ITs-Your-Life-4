package day01.array;

import java.util.Scanner;

// 시간 복잡도 주의
public class B11659 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// 구간합을 저장해놓는 array
		int[] arr = new int[n+1];
		
		// index 설정을 위해 0번째는 0으로 설정
		arr[0] = 0;
		
		for (int i = 1; i < n+1; i++) {
			arr[i] = arr[i-1] + sc.nextInt();
		}
		//[0, 5, 9, 12, 14, 15]
		for(int s = m; s > 0; s--) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			
			System.out.println(arr[j] - arr[i-1]);
			
		}
		

	}

}
