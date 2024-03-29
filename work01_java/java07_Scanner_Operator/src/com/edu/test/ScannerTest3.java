package com.edu.test;

import java.util.Scanner;

/*
 * - nextInt()
    - 공백을 기준으로 값을 반환
    - Enter을 치더라도 Enter값을 없애고 해당 라인에 커서가 위치한다
    - int의 해당하는 정수 값을 받아온다
    
    - next()
    - 공백을 기준으로 값을 반환
    - Enter을 치더라도 Enter값을 없애고 해당 라인에 커서가 위치한다 (Enter, 공백 모두 가능)
    - 문자열에 해당하는 문자 값을 받아온다
    
    - nextLine()
    - 공백을 기준이 아닌 라인을 기준으로 값을 반환
    - 커서의 위치가 해당 라인이 아닌 다음 라인에 위치한다.
    - 문자열에 해당하는 문자 값을 받아온다
    
 */

public class ScannerTest3 {

	public static void main(String[] args) {
		// 1. 키보드로 입력되는 값을 받아오는 Scanner 생성
		Scanner sc = new Scanner(System.in);
		// 2. 정수 값을 입력받는 기능
		System.out.println("숫자를 입력하시오");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		String name = sc.nextLine();
		
		//System.out.println("num1 : " + num1 + " , num2 : " + num2);
		System.out.printf("num1 : %d, num2 : %d, name : %s", num1, num2, name);
	}

}
