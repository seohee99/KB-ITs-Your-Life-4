package com.edu.test;

/*
 * Polymorphism
 * ::
 * 부모 타입으로 다양한 자식 객체를 생성
 * 1) Object Casting
 * 2) Virtual Method Invocation
 */


import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.utill.MyDate;

public class PolyTest1 {

	public static void main(String[] args) {
		Employee m = new  Manager("JK", new MyDate(1997,9,1), 40000.0, "IT");
		Employee e = new Engineer("JM", new MyDate(1995,10,13), 50000.0, "JAVA", 300.0);
		Employee s = new Secretary("J", new MyDate(1995,12,30), 4500.0, "Bang");
		
		// 1. James의 부서를 Marketing부서로 변경~
//		Manager m1 = (Manager) m;
//		m1.changeDept("Marketing");
		
		((Manager) m).changeDept("Marketing"); // objec casting
		
		// 2. 정보출력 
		/*
		 * Virtual Method Invocation
		 * 상속관계의 오버라이딩 된 메소드에서 
		 * 부모 타입으로 자식객체를 생성했을 때 발생하는 원리
		 * 
		 * 1. 컴파일 타입 메소드 --- 부모 메소드 호출
		 * 2. 런타임 타입 메소드 --- 실질적으로 생성된 자식의 메소드 
		 * 
		 */
		System.out.println(m);
		System.out.println(e);
		System.out.println(s);

	}

}
