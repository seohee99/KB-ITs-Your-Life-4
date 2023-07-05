package com.edu.bank;

public class Customer {
	public String cusName;
	public int ssn;
	public Account account; // 선언만으로 주입이 이루어지진 않는다 
	
	
	
	public Customer(String cusName, int ssn, Account account) {
		this.cusName = cusName;
		this.ssn = ssn;
		this.account = account;
	}
	public String getCustomerInfo() {
		return "이름 : " + cusName + " , " 
				+ "ssn : "	+ ssn + " , " 
				+ account.getAccountInfo();
	}
	public Account getAccount() {
		return account;
	}
	public String getName() {
		return cusName;
	}
	
	
	

}
