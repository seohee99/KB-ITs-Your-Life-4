package com.edu.test;

import java.util.Scanner;

/*
 * 지금까지 우리가 작성한 코드를 보면, 실제 값이 컴파일 시점에서 입력이 되었다.
 * 
 * 실행 시점에서 실제값을 입력하기 위해서는 Scanner를 사용해야한다
 * 
 * 실행시 값을 입력받는 방법
 * 1. 키보드로 입력
 * 2. 파일의 값을 입력
 * Scanner sc = new Scanner(System.in); -> 키보드
 * Scanner sc = new Scanner(new File("input.txt")); -> file
 * 
 * System.out : OutputStream (콘솔)
 * System.in : InputStream (키보드)
 * 
 * - nextInt()
    - 공백을 기준으로 값을 반환
    - Enter을 치더라도 Enter값을 없애고 해당 라인에 커서가 위치한다
    - int의 해당하는 정수 값을 받아온다
 */

public class ScannerTest1 {

	public static void main(String[] args) {
		// 1. 키보드로 입력되는 값을 받아오는 Scanner 생성
		Scanner sc = new Scanner(System.in);
		// 2. 정수 값을 입력받는 기능
		System.out.println("숫자를 입력하시오");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		//System.out.println("num1 : " + num1 + " , num2 : " + num2);
		System.out.printf("num1 : %d, num2 : %d", num1, num2);
	}

}
