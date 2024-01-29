package com.edu.test;

class StaticExam{
	// 필드는 객체생성시 메모리(힙)에 올라감
	// static은 필드가 아님
	// 필드 : 객체에 대입되는 specific 한 값
	// 객체의 specific한 값이 아니므로 힙에 안올라감(Class Area)
	// 따라서 gc의 대상이 안되기 때문에 성능이 떨어짐
	// 진짜 필요할 때만 써야함 -> 
	static String name = "Hobi"; // static V
	static int age = 29; // static V
	int count = 1; // field
	
	public static void getMemer() {
		System.out.println("우/유/빛/깔 " + name);
	}
	
	public void getMemer2() {
//		static String address = "성수동";
		System.out.println("I'm your " + name);
	}
}

public class StaticExamTest1 {

	public static void main(String[] args) {
		// 객체 생성 과정 없이 바로 사용 가능
		StaticExam.getMemer(); // static으로 선언한 건 객체 생성 안해도됨,대신 클래스명을 붙여줘야함 -> 그 클래스에 있는 메소드를 쓴다는 뜻
		
		
		// 객체 생성 = 클래스의 getMember2()가 메모리에 올라간다
		StaticExam se = new StaticExam();
		se.getMemer2(); 
	}

}
