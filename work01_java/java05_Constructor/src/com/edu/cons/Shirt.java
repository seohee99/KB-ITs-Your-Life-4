package com.edu.cons;

public class Shirt {
	public String brand;
	public boolean longSleeved;
	public char color;
	
	public Shirt(String brand, boolean longSleeved, char color) {
		this.brand = brand;
		this.color = color;
		this.longSleeved = longSleeved;
	} // 생성자는 void 안씀 
	
	// 값 주입
	// 밑에 brand, longSleeved, color은 지역 변수
	public void setShirt(String brand, boolean longSleeved, char color) {
		this.brand = brand;
		this.color = color;
		this.longSleeved = longSleeved;
	}
	
	// 값 반환
	public String getShirt() {
		return brand + "," + longSleeved + "," + color;
		
	}

}
