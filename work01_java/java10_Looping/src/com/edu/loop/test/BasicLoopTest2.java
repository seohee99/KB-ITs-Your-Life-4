package com.edu.loop.test;
/*
 * if 문과 함께 사용되는 반복문의 키워드
 * if + break
 * if + continue
 */

public class BasicLoopTest2 {

	public static void main(String[] args) {
		int total = 0; // 로컬 변수니까 초기값 필요함
		
		System.out.println("==========break=========");
		for(int member = 1; member < 10; member ++) {
			if (total >= 30) break;
			total += member;
			
		}
		System.out.println(total);
		
		System.out.println("=========continue==========");
		for(int num=1; num<=10; num++) {
			// 홀수의 총합
			if(num % 2 == 0) continue;
			total += num;
		}
		System.out.println(total);

	}

}
