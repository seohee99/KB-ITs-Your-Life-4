package com.edu.child;

import com.edu.parent.Employee;
import com.edu.utill.MyDate;

public class Engineer extends Employee{
	String mainSkill;
	double bonus;
	
	
	public Engineer(String name, MyDate birthday, double salary, String mainSkill, double bonus) {
		super(name, birthday, salary);
		this.mainSkill = mainSkill;
		this.bonus = bonus;
	}
	// 기능 추가
	public void changeMainSkill(String mainSkill) {
		this.mainSkill = mainSkill;
	}
	
	
	public void changeBonus(double bonus) {
		this.bonus = bonus;
	}


	public String getMainSkill() {
		return mainSkill;
	}


	public double getBonus() {
		return bonus;
	}


	


	@Override
	public String toString() {
		return super.toString() + " mainSkill=" + mainSkill + ", bonus=" + bonus;
	}
	
	

}
