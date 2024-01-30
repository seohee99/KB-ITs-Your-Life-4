package day01.array;

import java.util.Arrays;
import java.util.Scanner;

public class SW2001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int tc = 1 ; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			int[][] arr = new int[n][n];
			int[][] result = new int[n-m+1][n-m+1];
			
			//초기화
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length;j++)
					arr[i][j] = sc.nextInt();				
			}
			//result 배열에 결과값 담기
			for (int i = 0; i < result.length; i++) {
				for(int j = 0;j < result.length; j++ ) {
					
					int sum = 0;
					for(int a = i; a < i + m; a++) {
						for(int b = j; b < j + m; b++) {sum += arr[a][b];}
					}
					result[i][j] = sum;
				}
			}
			
			int max = 0;
			for (int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length ; j++) {if (result[i][j] > max) max = result[i][j];}
			}
			
			System.out.println("#" + tc + " " + max);
		}
		

	}

}
