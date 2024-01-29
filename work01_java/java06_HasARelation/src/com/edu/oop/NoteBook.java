//package 선언 부분이 가장 처음에 나옵니다.
// package는 무조건 소문자, 키워드는 제외, .을 기준으로 상위, 하위가 
package com.edu.oop;

import java.util.Vector;

public class NoteBook {
	// 필드 선언
	public String brand;
	public int price;
	public int serialNumber;
	//public Vector vector;
	
	/*
	 * this
	 * 로컬변수와 필드를 구분하기 위한 키워드로 필드 앞에 붙여준다
	 * this 키워드는 자기자신을 참조하는 주소값을 가지고 있따
	 */
	
	// 생성자는 메소드가 아님
	public NoteBook(String brand, int price, int serialNumber) {
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	// 기본 생성자 추가 .. -> 생성자 overloading 
	// 하나의 클래스에서는 반드시 하나 이상의 생성자가 존재한다
	// 명시적 생성자가 정의되어져 있지 않을때 무조건 기본 생성자를 넣어준다!!
	// 만약에 명시적 생성자가 정의되어져 있으면 그때는 자동으로 기본 생성자 X 
	public NoteBook() {}


	public String getNoteBookInfo() {
		return brand + "\t" + price + "\t" + serialNumber;
	}

}
