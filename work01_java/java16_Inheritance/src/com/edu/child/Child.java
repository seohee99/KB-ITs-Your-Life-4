package com.edu.child;

import com.edu.parent.Parent;

public class Child extends Parent {
	public void test() {
		// 부모 클래스(다른 디렉토리, 패키지에 들어있다)의 필드에 접근
		System.out.println(publicVar);
		System.out.println(protectedVar); // 상속관계에서만 가능 
		
//		System.out.println(var); 
//		System.out.println(privateVar);
	}
}
