package com.edu.test;

// 추상 메소드(구현부가 없고 선언부만으로 이루어진 메소드)들의 집합
interface Flyer{
	void fly(); // 무조건 앞에 public abstract가 붙는다
	void land();
	void takeOff();
}

class Bird implements Flyer{
	// 클래스는 구현안 된 메소드가 있어선 안됨
	@Override
	public void fly() {
		System.out.println("Bird fly..");
	}

	@Override
	public void land() {
		System.out.println("Bird land..");
	}

	@Override
	public void takeOff() {
		System.out.println("Bird takeOff..");
	}
	
	public String layEggs() {
		return "lay Eggs!!";
	}
	
	
}

class SuperMan implements Flyer{

	@Override
	public void fly() {
		System.out.println("SuperMan fly..");
		
	}

	@Override
	public void land() {
		System.out.println("SuperMan land..");
		
	}

	@Override
	public void takeOff() {
		System.out.println("SuperMan takeOff..");
		
	}
	
	
	public String stopBullet() {
		return "망또로 총알을 막는다";
	}
	
}



public class InterfaceTest1 {

	public static void main(String[] args) {
		// 추상 메소드가 있는 걸로는 객체 생성할 수 없음
		//Flyer f = new Flyer();
		
		// interface는 객체 생성 시 타입으로서는 가능 -> Polymorphism
		Flyer b = new Bird();
		Flyer s = new SuperMan();
		
		b.fly();
		s.fly();
		
		System.out.println(((Bird) b).layEggs());
		

	}

}
