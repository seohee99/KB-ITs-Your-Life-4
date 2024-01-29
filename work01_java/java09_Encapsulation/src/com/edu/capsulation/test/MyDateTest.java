package com.edu.capsulation.test;

import java.util.Scanner;

import com.edu.capsulation.MyDate;

public class MyDateTest {

	public static void main(String[] args) {

		MyDate md = new MyDate(); // calling, 명시적 생성자가 없으면 컴파일러가 자동으로 생성해줌(안보일뿐)
		/*
		 * - 다른 클래스에서 field에 직접적으로 접근을 못하게 함
    		- invalid한 값이 필드에 저장되지 못하게 막아야한다. → field앞에 private를 붙인다!
		 */
		// md.month = 33;
		// md.day = 33;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("month와 day를 입력하세요 : ");
		
		
		int month = sc.nextInt();
		int day = sc.nextInt();
		
		md.setMonth(month);
		md.setDay(day);
		
		if (md.getMonth() == 0 || md.getDay() == 0) {
			System.out.println("Invalid Value");
		}else {
			System.out.println("오늘은 " + md.getMonth() + "월 " + md.getDay() + "일 입니다");

		};
		
	}

}
