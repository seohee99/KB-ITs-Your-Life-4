package com.edu.capsulation;
/*
 * 오늘 날짜를 저장하는 클래스
 * valid 값만 month, day에 할당되도록 제어문을 사용
 * month 1~12 사이의 값만 필드 초기화 / "Invalid Month"
 * day
 * 1,3,5,7,8,10,12 : 1~31일
 * 4,6,9,11 : 1~30일
 * 2 : 1~28일
 * 
 * Encaptulation 작성 Pattern
 * 1. field 앞 -- private
 * 2. method (setter / getter) 앞 -- public
 * 3. setter 메소드 필드 초기화 하기 전에 타당한 값만 필드에 저장되도록 문장을 제어한다!!
 */
public class MyDate {
	// private : 같은 클래스에서만 접근을 허용
	private int month;
	private int day;
	
	// public MyDate(){} 생성자는 class modifier을 따라감
	

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		// 제어문 적용
		if (month > 12 || month < 1){
			this.month = 0;
			System.exit(0);
			
			}
		else this.month = month;
		
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (0 < day && day < 31) this.day = day;
			else {
				this.day = 0;
				System.exit(0);
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (0 < day && day < 31) this.day = day;
			else this.day = 0;
			break;
		case 2:
			if (0 < day && day < 29) this.day = day;
			else this.day = 0;
			break;
	}
		
	}
}