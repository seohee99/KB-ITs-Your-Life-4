package com.edu.domain.test;

import com.edu.domain.NoteBook;

/*
 * Class DataType의 배열을 생성, 초기화..
 * Memory Allocation
 */
public class ReferenceArrayTest1 {

	public static void main(String[] args) {
		// 1. 배열 생성
		NoteBook[] notebooks = new NoteBook[3]; // class 타입의 초기값은 null임
		for (NoteBook nb : notebooks) System.out.println(nb);
		System.out.println("============1===============");
		
		notebooks[0] = new NoteBook("HP",170,123);
		notebooks[2] = new NoteBook("LG",130,451);
		for (NoteBook nb : notebooks) System.out.println(nb);
		
		System.out.println("=============2==============");
		for (NoteBook nb : notebooks) {
			if (nb == null) continue;
			else System.out.println(nb.toString()); // error : 0,2 자리만 초기화해서! -> 조건 추가
		}
		
		System.out.println("=============3==============");
		for (NoteBook nb : notebooks) {
			if (nb == null) continue;
			else System.out.println(nb.toString()); //그냥 nb만 출력하는거랑 똑같음 -> reference 변수 뒤에 항상 toString이 생략되어있음
		}
		
		
		
	}

}
