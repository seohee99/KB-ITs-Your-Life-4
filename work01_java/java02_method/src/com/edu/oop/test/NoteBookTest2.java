package com.edu.oop.test;

import com.edu.oop.Notebook;
/*
 * 문제점
 * 필드에 일일이 값 할당(초기화)하고 있다
 * 필드의 개수가 늘어나면 코드라인도 느러나고 가독력도 떨어진다
 */

public class NoteBookTest2 {

	public static void main(String[] args) {
		Notebook n = new Notebook();
		/*
		 * n.brand = "Apple"; n.price = 3000000; n.serialNumber = 1;
		 */
		
		n.setNotebook("Apple", 3000000, 123);
		n.printNoteBookInfo();

	}

}
