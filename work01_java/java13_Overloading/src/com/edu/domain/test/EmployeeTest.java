package com.edu.domain.test;

import com.edu.domain.Employee;
import com.edu.util.MyDate;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee emp1 = new Employee("James",new MyDate(2000, 1, 1));
		Employee emp2 = new Employee("kook", 340000.0, new MyDate(1997, 9, 1));
		Employee emp3 = new Employee("Jimin",500000.0, new MyDate(1995, 10, 13));
		
		// Employee 타입의 배열 생성
		Employee[] emps = {emp1, emp2, emp3};
		
		for (Employee emp: emps) System.out.println(emp);
	
	}

}
