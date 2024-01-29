package com.edu.parent;

import com.edu.utill.MyDate;

// Parent Class
public class Employee {
	private String name;
	private MyDate birthday;
	private double salary;
	
	public Employee() {};
	
	public Employee(String name, MyDate birthday, double salary) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.salary = salary;
	}

	public String getDetails() {
		return "Employee [name=" + name + ", birthday=" + birthday + ", salary=" + salary + "]";
	}
	
	
	
	
	
}
