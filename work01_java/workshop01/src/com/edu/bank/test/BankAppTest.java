package com.edu.bank.test;

import java.util.Scanner;
import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankAppTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Customer 동은 생성
		// c1(동은)의 계좌번호, 잔액 입력(Scanner)
		System.out.println("동은의 계좌번호를 입력하세요 : ");
		int c1Account = sc.nextInt();
		System.out.println("동은의 잔액을 입력하세요 : ");
		double c1Balance = sc.nextDouble();
		
		// 통장 생성
		Account kb1 = new Account(c1Account, c1Balance, "국민은행"); 
		Customer c1 = new Customer("동은", 1, kb1);
		
		// 생성된 통장 초기 정보 출력
		System.out.println("현재 동은님의 초기 정보를 출력합니다");
		System.out.println(c1.getCustomerInfo());
		
		// 통장의 기능 사용 
		// 입금
		System.out.println("얼마를 입금하시겠습니까? :");
		double c1deposit1 = sc.nextDouble();
		kb1.deposit(c1deposit1);
		// 3만원 출금
		System.out.println("얼마를 출금하시겠습니까? :");
		double c1withdraw = sc.nextDouble();
		kb1.withdraw(c1withdraw);
		// 입금2
		System.out.println("얼마를 입금하시겠습니까? :");
		double c1deposit2 = sc.nextDouble();
		kb1.deposit(c1deposit2);
		
		// 최종 정보 출력
		System.out.println("최종 동은님의 정보를 확인합니다");
		System.out.println(c1.getCustomerInfo());
		
		//////////////////////////////////////////////////////////
		// Customer 동은 생성
		// c2(지수)의 계좌번호, 잔액 입력(Scanner)
		System.out.println("지수의 계좌번호를 입력하세요 : ");
		int c2Account = sc.nextInt();
		System.out.println("지수의 잔액을 입력하세요 : ");
		double c2Balance = sc.nextDouble();
		
		// 통장 생성
		Account kb2 = new Account(c2Account, c2Balance, "국민은행"); 
		Customer c2 = new Customer("지수", 2, kb2);
		
		// 생성된 통장 초기 정보 출력
		System.out.println("현재 지수님의 초기 정보를 출력합니다");
		System.out.println(c2.getCustomerInfo());
		
		// 통장의 기능 사용 
		// 입금
		System.out.println("얼마를 입금하시겠습니까? :");
		double c2deposit1 = sc.nextDouble();
		kb1.deposit(c2deposit1);
		// 3만원 출금
		System.out.println("얼마를 출금하시겠습니까? :");
		double c2withdraw = sc.nextDouble();
		kb1.withdraw(c2withdraw);
		// 입금2
		System.out.println("얼마를 입금하시겠습니까? :");
		double c2deposit2 = sc.nextDouble();
		kb1.deposit(c2deposit2);
		
		// 최종 정보 출력
		System.out.println("최종 지수님의 정보를 확인합니다");
		System.out.println(c2.getCustomerInfo());		
		
		

	}

}
