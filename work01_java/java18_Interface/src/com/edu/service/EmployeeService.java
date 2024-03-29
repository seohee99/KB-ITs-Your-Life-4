package com.edu.service;

import com.edu.parent.Employee;

//사용자와 벤더사 사이의 강력한 contract 
public interface EmployeeService {
	
	void printAllEmployee(Employee[] emps);
	Employee findEmployee(Employee[] emps, String name);
	Employee[] findEmployeeByDept(Employee[] emps, String dept);
	double getAnnualSalary(Employee e);
	double getTotalCost(Employee[] ea);
	
}
