package com.edu.bank;
//제어문 추가
/*
  1. 입금(deposit..)시 1천원 이상의 금액만 입금 / 
     "입금액은 1천원~"..다시 되돌린다. return
  2. 출금(withdraw..)시 잔액보다 더 큰금액은 출금이 안되도록 / 
     "출금액이 잔액보다~~"..다시 되돌린다. return
 */
public class Account {
	private int accNumber;
	private String bankName;
	private double balance;
	
	public Account() {}
	public Account(int accNumber, String bankName, double balance) {
		super();
		this.accNumber = accNumber;
		this.bankName = bankName;
		this.balance = balance;
	}

	public int getAccNumber() {
		return accNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public double getBalance() {
		return balance;
	}
	//나머지 기능을 추가...입금/출금...제어문
	public void deposit(double amount) {
		if(amount>=1000.0) {
		   balance += amount;
		}else {
			System.out.println("입금액은 1천원 이상입니다.");
			return;//호출한 지점으로 로직을 다시 돌림.
		}
		
	}
	public void withdraw(double amount) {
		if(balance>=amount) {
			balance -= amount;
		}else {
			System.out.println("잔액보다 출금액이 더 많습니다");
			return;
		}		
	}
	//필드값 리턴
	@Override
	public String toString() {
		return accNumber+"-"+bankName+"-"+balance;
	}	
}


