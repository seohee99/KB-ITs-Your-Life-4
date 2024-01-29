package com.edu.bank;

public class Customer {
	private int ssn;
	private String custName;

	private Account[] accounts; // 선언만으로 주입이 이뤄지진 않는다.

	public Customer(int ssn, String custName) {
		super();
		this.ssn = ssn;
		this.custName = custName;
	}
	
	// 수정
	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public String getCustomerInfo() {
		return ssn + "-" + custName;
	}
}