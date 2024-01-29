package com.edu.oop;
// NoteBook에 대한 정보를 저장하는 클래스
public class NoteBook {
	// 필드 선언
	public String brand;
	public int price;
	public int serialNumber;
	
	// 필드에 값을 할당하는 기능을 추가
	// 필드에 값 주입 == 필드초기화
	public void setNotebook(String brand, int price, int serialNumber) {
		// 필드와 로컬 변수를 구분하기 위해서 this 키워드를 필드 앞에 붙인다
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
		
	}
	// 메소드 정의(선언부 + 구현부) 
	// 메소드는 return type을 가짐,만약 return type이 void면 반환값이 없다는 의미의 return type
	// 반환값을 String으로 지정 -> void가 아니면 메소드 안에 return이 무조건 포함되어야함
	// ~Test 클래스(호출한 곳)로 리턴 -> 거기서 출력!
	public String getNoteBookInfo() {
		return brand + "\t" + price + "\t" + serialNumber;
	}

}
