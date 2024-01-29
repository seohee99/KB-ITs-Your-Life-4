package com.edu.oop.test;

import com.edu.oop.NoteBook;
import com.edu.oop.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		 * 1. 객체 생성
		 * 2. 기능을 호출
		 * ------------------------------------------
		 * 1. James라는 개발자를 생성 : 정보를 입력 (이름, 주요기술, 급여)
		 * 2. James가 HP 노트북을 구매 : setter 주입
		 * 3. James가 구매한 노트북을 return받아서 노트북의 정보를 출력
		 * 4. James의 변경된 mainSkill, salary를 출력
		 */
		
		Programmer p1 = new Programmer("James", "JAVA", 500);
		p1.buyNoteBook(new NoteBook("HP", 170, 123));
		
		System.out.println("James가 구매한 노트북 정보입니다..");
		System.out.println(p1.getNoteBook().getNoteBookInfo());
		
		System.out.println("\nJames 변경된 mainSkill 정보입니다..");
		p1.changeMainSkill("Python");
		System.out.println(p1.getMainSkill());
		
		System.out.println("\nJames 변경된 급여입니다..");
		p1.incrementSalary(50);
		System.out.println(p1.getSalary());
		

	}

}
