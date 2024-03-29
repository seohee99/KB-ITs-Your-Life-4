package com.edu.cons.test;
/*
 * 오전에 정리한 자바의 DataType을 이해할 수 있는 클래스 작성
 * 2개의 클래스를 한번에 작성할 때는 
 * 1. main()을 가지고 있는 클래스 앞에만 public을 지정
 * 2. public으로 지정된 클래스 명으로 java file이 저장되어야 한다
 */
class Date{
	int year;
	int month;
	int day;
	
	//생성자
	public Date(int year, int month, int day) {
		//필드 초기화...주입의 통로를 생성자로 결정 
		this.year = year;
		this.month = month;
		this.day = day;
	}
	/*
	 * String + Non-String ==> String화
	 */
	public String getDate() {
		return year + "-" + month + "-" + day;
	}
}
class WhiteBoard{
	// 1. 필드 선언
	String madeCompany;
	float price;
	boolean scratch;
	char size;
	//추가..제조일자
	Date madeDate; // 클래스에는 어떤 데이터 타입이든 넣을 수 있으므로 클래스 형식의 데이터 타입은 아주 강력함!
	
	// 2. 필드 주입 기능 정의 (void | 인자값)
	public void setWhiteBoard(String madeCompany, float price, boolean scratch, char size, Date madeDate) {
		this.madeCompany = madeCompany;
		this.price = price;
		this.scratch = scratch;
		this.size = size;
		this.madeDate = madeDate;
	}
	// 3. 주입된 필드 값을 반환(??? | 인자값 X)
	public String getWhiteBoard() {
		return madeCompany + " , " + price + " , " + scratch + " , " + size+ " , " + scratch + " , " + madeDate.getDate();
	}
}

public class WhiteBoardTest {

	public static void main(String[] args) {
		//객체 생성 ... new ... 메모리에 로딩
		WhiteBoard wb = new WhiteBoard();

		// 1. set~~() 호출 : 필드값이 채워진다
		// 인자값의 개수, 순서, 타입이 일치해야한다.
		wb.setWhiteBoard("동신사", 37000.0f, false, 'L', new Date(2023,7,4)); // 객체 자체가 값이 됨
		
		// 2. system.out.println(get~~()호출)
		System.out.println(wb.getWhiteBoard());

	}

}
