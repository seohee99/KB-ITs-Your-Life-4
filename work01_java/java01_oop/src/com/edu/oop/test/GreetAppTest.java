package com.edu.oop.test;
/*
 * ~Test 클래스가 하는 일
 * 1) 변수에 값을 입력
 * 2) 메소드는 호출
 */

import com.edu.oop.Greet;

public class GreetAppTest {

	public static void main(String[] args) {
		// main method를 가지는 class는 실행 class / test class
		Greet g = new Greet();
		// initialization 초기화(처음 넣는 값이라는 뜻이 아닌, 새로운 값 할당을 의미함)
		g.target = "KB IT's Your Life 4기"; // '='은 같다는 의미가 아니라 할당한다는 의미, '.'은 at의 의미
		g.message = "Hello Java~~~";
		
		// 메소드 호출
		g.sayHello();
		}

}
