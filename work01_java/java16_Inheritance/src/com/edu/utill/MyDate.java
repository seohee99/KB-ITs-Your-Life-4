package com.edu.utill;

public class MyDate {
	private int year;
	private int month;
	private int day;
	
	
	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}


	@Override
	public String toString() {
		return "year=" + year + ", month=" + month + ", day=" + day ;
	}
	
	
	
	

}
