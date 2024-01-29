package com.edu.test;

import javax.swing.text.GapContent;

/*
 * Polymorphism
 * ::
 * 부모 타입으로 다양한 자식 객체를 생성
 * 1) Object Casting
 * 2) Virtual Method Invocation
 */


import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.service.EmployeeService;
import com.edu.service.impl.EmployeeServiceImpl;
import com.edu.utill.MyDate;

public class PolyTest3 {

	public static void main(String[] args) {
//		Employee m = new  Manager("JK", new MyDate(1997,9,1), 40000.0, "IT");
//		Employee eg = new Engineer("JM", new MyDate(1995,10,13), 50000.0, "JAVA", 300.0);
//		Employee s = new Secretary("J", new MyDate(1995,12,30), 4500.0, "Bang");
		
		// Heterogeneous Collection
		// 베열의 전제조건(same data type)이 여기서 무너지다 .. -> 상속이라 가능한 일
		Employee[] emps = {
				new  Manager("JK", new MyDate(1997,9,1), 40000.0, "IT"),
				new Engineer("JM", new MyDate(1995,10,13), 50000.0, "JAVA", 300.0),
				new Secretary("V", new MyDate(1995,12,30), 4500.0, "Bang"),
				new Engineer("JIN", new MyDate(1992,12,4), 50000.0, "Python", 500.0),
				new  Manager("RM", new MyDate(1994,9,12), 80000.0, "IT")};
		
//		System.out.println("=============정보를 출력합니당=============");
//		for(Employee e : emps)System.out.println(e);
//		
//		System.out.println("\n=============정보를 출력합니당=============");
////		for(Employee e: emps) System.out.println(e.getName() + " : " + e.getSalary());
//		
//		// e의 객체 타입을 알아야 할 때 : instance of 사용
//		double annualSalary = 0.0;
//		for(Employee e:emps) {
//			if(e instanceof Engineer) {
//				annualSalary = e.getSalary() * 12 + ((Engineer) e).getBonus();
//				System.out.println(e.getName() + "님의 연봉 : " + annualSalary);
//			}else {
//				annualSalary = e.getSalary() * 12;
//				System.out.println(e.getName() + "님의 연봉 : " + annualSalary);
//			}
//		}
		
		// Service 객체 생성
		EmployeeService es = EmployeeServiceImpl.getInstance();
		System.out.println("=====1. 직원 정보를 출력합니다========");
		es.printAllEmployee(emps);
		
		System.out.println("\n=====2. 특정 직원을 검색합니다========");
		System.out.println(es.findEmployee(emps, "V"));
		
		System.out.println("\n=====3. 동일한 부서의 직원을 검색합니다.========");
		Employee[] sd = es.findEmployeeByDept(emps, "IT");
		for(Employee e:sd) {
			if (e != null) System.out.println(e);
		}
		
		System.out.println("\n=====4. 특정 직원의 연봉을 검색합니다========");
		System.out.println(emps[0].getName() + "의 연봉 : " + es.getAnnualSalary(emps[0]));
		
		System.out.println("\n=====5. 직원의 총 인건비를 검색합니다========");
		System.out.println(es.getTotalCost(emps));
		
	}

}
