package com.edu.test;
/*
 * Singleton Pattern
 * ::
 * 클래스로부터 오직 단 하나의 객체만 생성하도록 하는 디자인 패턴
 * ::
 * <Syntax>
 * 1. 일단 클래스 안에서 객체 하나는 먼저 생성
 * 		static private 객체 생성
 * 2. 다른 클래스에서는 객체 생성 못하도록 막아둔다
 * 		private 생성자
 * 3. 하나 생성한 객체를 여기저기서 갖다 쓰도록 public한 기능으로 리턴 받아둔다
 * 		이때 반드시 static한 성질의 메소드로 만들어둔다 ***
 * 		public static Instance getInstance();
 */

class ServiceImpl{
	static private ServiceImpl service = new ServiceImpl(); // 1
	
	private ServiceImpl() { //2
		System.out.println("Singleton pattern ready");
	}
	
	public static ServiceImpl getInstance() { //3
		return service;
	}
}
public class StaticExamTest5 {

	public static void main(String[] args) { 
		
		//ServiceImpl ss = new ServiceImpl();
		ServiceImpl s1 = ServiceImpl.getInstance();
		ServiceImpl s2 = ServiceImpl.getInstance();
		ServiceImpl s3 = ServiceImpl.getInstance();
		
		System.err.println(s1);
		System.err.println(s2);
		System.err.println(s3);
		
	}
	
}
