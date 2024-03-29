package com.edu.test;

import java.util.Arrays;
import java.util.Scanner;

/*
 <<Data sample >>
 6
 1 4 4 4 5 3
 
 */
public class PersonTypeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Sample Data Input >>> ");

		// 사람수 입력
		int n = sc.nextInt();

		// 사람수만큼 배열 생성
		int personality[] = new int[n];
		// 성격 유형 배열 생성(인덱스 0은 사용하지않음)
		int perCount[] = new int[6];

		// 성격 유형 입력
		for (int i = 0; i < personality.length; i++) {
			personality[i] = sc.nextInt();
		}

		// for문으로 배열의 성격 유형 하나씩 검사

		for (int i = 0; i < personality.length; i++) {
			switch (personality[i]) {
			case 1:
				perCount[1] += 1;
				break;
			case 2:
				perCount[2] += 1;
				break;
			case 3:
				perCount[3] += 1;
				break;
			case 4:
				perCount[4] += 1;
				break;
			case 5:
				perCount[5] += 1;
				break;
			}
		}
		// 배열의 max값 찾기
		int answer = 0;
		for (int i = 0; i < perCount.length; i ++) {
			if (answer < perCount[i]) answer = i;
		}
		System.out.println("가장 많은 타입의 유형은 " + answer + "입니다");

	}
}
