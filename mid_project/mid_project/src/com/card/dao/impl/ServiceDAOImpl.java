package com.card.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

import com.card.dao.ServiceDAO;
import com.card.util.MyDate;
import com.card.vo.Purchase;

import config.ServerInfo;

public class ServiceDAOImpl implements ServiceDAO{
	
	////////////////////     공통적인 로직      //////////////////////////////////
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER_NAME, ServerInfo.PASSWORD);
		System.out.println("DB Connect....");		
		return conn;
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();		
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps,conn);		
	}

	@Override
	public void buy(int cardId, String catgory, int price, String date) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Purchase> getPurchase(String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Purchase> getPurchaseByCompany(String companyName, String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Purchase> getPurchaseByPeriod(String companyName, String cardId, MyDate start, MyDate end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Purchase> getPurchaseByCategory(String companyName, String cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Purchase> getPurchaseByFiltering(String companyName, int criteria, boolean flag) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalAmount(String ssn) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String checkGrade(String companyName, String ssn) {
		// TODO Auto-generated method stub
		return null;
	}

}
