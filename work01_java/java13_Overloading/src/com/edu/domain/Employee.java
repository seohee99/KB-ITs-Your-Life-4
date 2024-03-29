package com.edu.domain;

import com.edu.util.MyDate;

// 직원에 대한 정보를 저장하는 클래스
/* 
 * 접근하는 범위를 지정하는 키워드
 * << Access Modifier >>
 * private
 * public
 * 
 * 생성자 overloading
 * 필수적인 정보로만 객체를 생성
 * 미처 입력되지 않은 정보는 기본값으로 채울 때 반드시 필요한 기법
 * 이때 다른 생성자를 호출하기 위한 this 키워드를 사용한다
 */
public class Employee {
	private String name;
	private double salary;
	private MyDate birthDate;

	public Employee() {
	}; // 기본 생성자는 default로 넣어주는 것이 좋다
	
	// salary의 기본값 지정 (상수호 지정)
	public static final double BASIC_SALARY = 100.0;
	
	/*
	 * 생성자 앞의 this
	 * 같은 클래스 내에서 또다른 생성자를 호출할 때 사용
	 */
	
	public Employee(String name,  MyDate birthDate) {
		// () 안에 값을 생성자에 넣는다 -> 결론적으로 값이 없어도 기본값을 설정하여 넣겠다
		this(name, BASIC_SALARY , birthDate); // salary X -> salary를 100으로 채움(아니면 0 / null들어감)
	}

	public Employee(String name, double salary, MyDate birthDate) {
		super();
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	@Override
	public String toString() {
		return name + ", " + salary + ", " + birthDate;
	}

}
