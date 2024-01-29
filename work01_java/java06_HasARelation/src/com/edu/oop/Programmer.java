package com.edu.oop;

public class Programmer {
	//생성자 주입
	public String name;
	public String mainSkill;
	public int salary;
	
	//setter 주입 
	/////////////////Has a Relation//////////////////
	public NoteBook noteBook;

	public Programmer(String name, String mainSkill, int salary) {
		this.name = name;
		this.mainSkill = mainSkill;
		this.salary = salary;
	}
	
	public void buyNoteBook(NoteBook noteBook) { // set의 의미
		this.noteBook = noteBook;
	}
	
	public NoteBook getNoteBook() {
		return noteBook;
	}
	
	public void changeMainSkill(String mainSkill) { // set의 의미 (직관적인 identifier)
		this.mainSkill = mainSkill;
	}

	public String getMainSkill() {
		return mainSkill;
	}
	
	// 기능 추가
	public int annualSalary() {
		return salary * 12;
	}
	
	public void incrementSalary(int amt) {
		// salary = salary + amt;
		salary += amt;
	}
	public int getSalary() {
		return salary;
	}

	

	

	
	
	

}
