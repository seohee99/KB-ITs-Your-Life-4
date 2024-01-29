package com.edu.array2.test;
/*
 * 배열의 특징
 * 1. 여러 개의 값을 하나로 묶는 객체 → Data Type이 같아야 함!!
	2. 배열은 사이즈를 변경할 수 없다 (resizing이 불가)
	3. 사이즈가 다른 배열의 element값을  copy해 올 수는 있다.
	4. 배열은 클래스 타입이 존재하지 않는 개체이다.	-> field는 length하나
 * 
 */

class Person{
	String name;
	int age;
}
public class ArrayTest3 {

	public static void main(String[] args) {
		int[ ] target = {1, 2, 3, 4, 5, 6}; // 6
		int[ ] source = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};// 10
		
		//  사이즈가 다른 배열 source의 내용을 copy해서 target 값 변경
		//	8, 7, 6, 5, 4, 3이 되도록 합니다. System.arraycopy()
		
		/*
		 * arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		 */
		System.arraycopy(source, 2, target, 0, target.length);
		for (int i: target) System.err.println(i);
		
		System.out.println("=================");
		Person p = new Person();
		System.out.println("p" + p); // 주소값이 출력됨 : FQCN(Full Qualified Class Name)
		System.out.println(target);
	}//main

}
