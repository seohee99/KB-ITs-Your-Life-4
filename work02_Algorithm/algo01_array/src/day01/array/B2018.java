package day01.array;

import java.util.Arrays;
import java.util.Scanner;

public class B2018 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start = 1, end = 1, sum = 1, ans = 0;
		
		//(n/2)+1로 바꾸면 시간이 절약됨, end가 n까지 못가기때문에 ans = 1로 바꿔야함
		while(end <= n) {
			if(sum == n) { // 일치
				ans ++;
				sum -= start;
				start ++;
				end ++;
				sum += end;
				// sum = sum - start++ + ++end
			}else if(sum > n) { // 초과 -> start를 더해줌
				sum -= start;
				start ++;
				// sum -= start++
			}else { // 부족 -> end를 더해줌
				end ++;
				sum += end;
			}
		}
		System.out.println(ans);
		
		

	}

}
