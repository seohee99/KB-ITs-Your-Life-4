package com.edu.oop.test;

import com.edu.oop.NoteBook;

public class NoteBookTest {

	public static void main(String[] args) {
		/*
		 * 1. 객체 생성 == class의 멤버를 메모리에 올린다
		 * 2. 멤버에 접근
		 * 		필드 -> 값 할당
		 * 		메소드 -> 호출
		 * 3. 이 외에 어떤것도 test에서 하지않는닷!!
		 */
		
		// 생성되는 객체의 Type | 필드 초기화
		NoteBook nb1 = new NoteBook("LG",170, 12);
		nb1.brand = "HP";
		System.out.println(nb1.getNoteBookInfo());
		
		// 기본 생성자
		NoteBook nb2 = new NoteBook();
	}
	
	

}
