package day01.array;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    
	    int cnt=0;
	    int N = sc.nextInt();
	    int[][] arr = new int[100][100];
	    
	    
	    for (int i = 0; i < N; i++) {
	        int s1 = sc.nextInt();
	        int s2 = sc.nextInt();
	        for (int j = s1; j < s1+10; j++) {
	            for (int k = s2; k < s2+10; k++) {
	                    arr[j][k] = 1;
	                
	            }
	        }
	        
	    }
	    for (int i = 0; i < 100; i++) {
	        for (int j = 0; j < 100 ; j++) {
	            if(arr[i][j] == 1) {
	            cnt++;
	            }
	        }
	    }
	    
	    
	    System.out.println(cnt);

	}

}
