package com.card.dao;

import java.util.ArrayList;

import com.card.util.MyDate;
import com.card.vo.Purchase;

public interface ServiceDAO {
	void buy(int cardId, String catgory, int price, String date); //결제
	
	ArrayList<Purchase> getPurchase(String ssn);
	ArrayList<Purchase> getPurchaseByCompany(String companyName, String ssn); //세부 회사 내역	
	ArrayList<Purchase> getPurchaseByPeriod(String companyName, String cardId, MyDate start, MyDate end); //기간별 분석
	ArrayList<Purchase> getPurchaseByCategory(String companyName, String cardId); //카테고리별 소비 분석		
	ArrayList<Purchase> getPurchaseByFiltering(String companyName, int criteria, boolean flag); //필터
	int getTotalAmount(String ssn); //총합계
	
	String checkGrade(String companyName, String ssn); //등급확인
}
