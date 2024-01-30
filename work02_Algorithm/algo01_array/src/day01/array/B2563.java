package day01.array;

import java.util.Arrays;
import java.util.Scanner;

public class B2563 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n ; i++) {
			// 색종이 시작 위치
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			// 색종이 붙이기
			for (int x = a ; x < a+10 ; x++) {
				for(int y = b ; y < b+10; y++) {
					arr[x][y] += 1;
				}
			}
			//
			
		}
		int cnt = 0;
		for(int i = 0; i<arr.length;i++) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[i][j] != 0) cnt += 1;
			}
		}
		System.out.println(cnt);

	}

}
