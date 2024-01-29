package com.edu.test;

class Person{
	String name;
	
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	
}
// global한 초기화가 필요하다면 static 블럭을 이용

public class StaticExamTest4 {
	static int counter;
	public static void main(String[] args) { // 1. jvm이 가장 먼저 찾아서 실행 (객체 생성에서 값을 주입하는 게 원래는 1순위)
		Person p = new Person("James");
		System.out.println("James Person Instance Initialization");
	}
	// main보다 먼저 동작
	// 유일하게 main보다 먼저 인식하고 실행하는 부분
	
	static {
		counter ++;
		System.out.println("Static initialization block .." + counter);
	}

}
