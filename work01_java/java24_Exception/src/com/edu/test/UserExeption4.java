package com.edu.test;

class  ZeroBoom extends Exception{
	ZeroBoom() {
		this("This is ZeroBoom Exception....");
		
	}
	ZeroBoom(String message) {
		super(message);
	}
	
	
	
}

class User{
	public void go() throws ZeroBoom{
		int i=10;
		int j=0;
		System.out.println(" go()...진입...");
		// j가 0이라면 Exception을 발생
		if(j==0) throw new ZeroBoom("분모가 0 이면 안됨니다!!!!!!!!!!!");
		System.out.println(" ArithmeticException 터짐 ㅜ");
	}
}

public class UserExeption4 {

	public static void main(String[] args) {
		User user = new User();
		System.out.println(" go . . . .호출");
		try{
			user.go();
		}catch (ZeroBoom e) {
			System.out.println(e.getMessage());
		}

	}

}
