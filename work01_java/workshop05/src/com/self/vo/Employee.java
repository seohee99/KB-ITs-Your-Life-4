package com.self.vo;

import com.self.util.MyDate;

// Parent Class 
public class Employee {
	
	private String name;
	private double salary;
	private MyDate birthDate;
	
	public Employee() {}

	public Employee(String name, double salary, MyDate birthDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	
	

	@Override
	public String toString() {
		return "name=" + name + ", salary=" + salary + ", birthDate=" + birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	};
	
	
	
}
