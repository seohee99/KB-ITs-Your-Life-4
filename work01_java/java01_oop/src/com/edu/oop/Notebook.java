package com.edu.oop;

public class Notebook {
	// 필드 선언
	public String brand;
	public int price;
	public int serialNumber;
	
	// 메소드 정의(선언부 + 구현부) 
	public void printNoteBookInfo() {
		System.out.println("brand : " + brand);
		System.out.println("price : " + price);
		System.out.println("serialNumber : " + serialNumber);
	}

}
