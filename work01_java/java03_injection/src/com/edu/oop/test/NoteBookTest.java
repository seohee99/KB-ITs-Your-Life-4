package com.edu.oop.test;

import com.edu.oop.NoteBook;
/*
 * 문제점
 * 필드에 일일이 값 할당(초기화)하고 있다
 * 필드의 개수가 늘어나면 코드라인도 느러나고 가독력도 떨어진다
 */

public class NoteBookTest {

	public static void main(String[] args) {
		NoteBook n = new NoteBook();
		
		// 1. 값이 주입되는 함수 호출
		n.setNotebook("Apple", 2500000, 23);
		
		// 2. 값을 반환하는 함수 호출
		System.out.println(n.getNoteBookInfo());
	}

}
