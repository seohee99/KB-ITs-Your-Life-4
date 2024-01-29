package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.utill.MyDate;

public class InheritanceTest1 {

	public static void main(String[] args) {
		Manager m = new  Manager("JK", new MyDate(1997,9,1), 40000.0, "IT");
		Engineer e = new Engineer("JM", new MyDate(1995,10,13), 50000.0, "JAVA", 300.0);
		Secretary s = new Secretary("J", new MyDate(1995,12,30), 4500.0, "Bang");
		
		System.out.println(m.getDetails());
		System.out.println(e.getDetails());
		System.out.println(s.getDetails());

	}

}
