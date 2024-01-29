package com.self.service;

import com.self.vo.Employee;
import com.self.vo.Manager;

public interface EmployeeService {
	void addEmployee(Employee e);
	void deleteEmployee(String name);
	void updateEmployee(Employee e);
	void findEmployee(Employee e);
	void printAllEmployee();
	

}
