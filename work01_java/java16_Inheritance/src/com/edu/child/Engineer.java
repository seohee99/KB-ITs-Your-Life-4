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


	@Override
	public String getDetails() {
		return super.getDetails() + "Engineer [mainSkill=" + mainSkill + ", bonus=" + bonus + "]";
	}
	
	

}
