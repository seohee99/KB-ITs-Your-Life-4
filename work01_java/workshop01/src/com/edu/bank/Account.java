package com.edu.bank;

public class Account {
	public int accNumber;
	public double balance;
	public String bankName;
	
	public Account(int accNumber, double balance, String bankName) {
		this.accNumber = accNumber;
		this.balance = balance;
		this.bankName = bankName;
	}
	public String getAccountInfo() {
		return "계좌 번호 : " + accNumber + " , " 
				+ "잔액 : " + balance + " , " 
				+ "은행명 : "+ bankName;
	}
	public double getBalance() {
		return balance;
	}
	public void deposit(double amt) {
		balance += amt;
	}
	public void withdraw(double amt) {
		balance -= amt;
	}
	public String getBankName() {
		return bankName;
	}
	
	
}
