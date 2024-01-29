package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest1 {

	public static void main(String[] args) {
		/*
		 * 1. Account 타입의 배열 생성
		 * 2. 111, 국민은행, 12만원
		 * 	  222, 신한은행, 340만원
		 *    333, 하나은행, 9만원
		 * 3. 김국민이라는 고객이 1번에서 생성된 배열을 가짐
		 * 	  김국민에게는 국민은행, 신한은행, 하나은행 통장을 개설
		 * 4. 반복문을 사용해서 김국민이 개설한 통장의 정보를 출력
		 */
		
		Account[] acArr = {
				new Account(111,"국민",9),
				new Account(222,"신한",340),
				new Account(333,"하나",12) };
		
		Customer custom = new Customer(123, "김국민");
		custom.setAccounts(acArr);
		
		Account[] accs = custom.getAccounts();
		
		System.out.println("개설한 통장의 정보입니다.");
		for (Account a: accs) System.out.println(a);
		
		System.out.println("==============");
		
		// 1. 김국민이 개설한 통장 중에ㅓ 국민은행 통장을 찾아서 해당 통장의 잔액을 출금
		// 2. 김국민이 개설한 통장의 모든 잔액의 총합을 출력
		// 3. 김국민이 개설한 통장 중에서 가장 많은 잔액이 들어있는 통장의 이름과 해당 잔액을 출금
		
		for (Account a:accs) {
			if (a.getBankName().equals("국민")) System.out.println("국민은행 잔액 : " + a.getBalance());
		}
		
		double sum = 0;
		for (Account a:accs) {
			sum += a.getBalance();
		}
		System.out.println("모든 잔액의 총합 : "+sum);
		
		double max = 0;
		int index = 0;
		for (int i = 0; i < accs.length; i++) {
			if (accs[i].getBalance() > max) {
				max = accs[i].getBalance();
				index = i;
			}
		}
		System.out.println("가장 많은 잔액의 통장 정보\n" + accs[index].getBankName() + " " + accs[index].getBalance());
		
		
		
		
		
		
		

	}

}
