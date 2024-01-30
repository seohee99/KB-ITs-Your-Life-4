package com.jdbc.dao.impl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
// Singleton pattern
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.dao.CustomDAO;
import com.jdbc.vo.Custom;

import config.ServerInfo;

public class CustomDAOImpl implements CustomDAO{
	
	private static CustomDAOImpl dao = new CustomDAOImpl();
	
	private CustomDAOImpl() {
		System.out.println("CustomDAOImpl Creating...");
	}
	
	public static CustomDAOImpl getInstance() {
		return dao;
	}
	////////////// 공통 로직/////////////////////
	private Connection getConnect() throws SQLException{
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER_NAME, ServerInfo.PASSWORD);
		System.out.println("Database Connection...");
		
		return conn;
	}
	
	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException{
		if(ps != null) ps.close();
		if(conn  != null) conn.close();
	}
	
	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException{
		if(rs != null) rs.close();
		closeAll(conn, ps);
	}

	
	//////////////비즈니스 로직/////////////////////
	
	public boolean idExists(int id, Connection conn) throws SQLException {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT id FROM custom WHERE id=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		return rs.next();
			
	}
	
	@Override
	public void addCustom(Custom cust) throws SQLException {
		// 존재 유무 확인!!
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(!idExists(cust.getId(),conn)) { // id가 없다면... 추가진행
				
				String query = "INSERT INTO custom (id, name, address) VALUES(?,?,?)";
				ps = conn.prepareStatement(query);
				ps.setInt(1, cust.getId());
				ps.setString(2, cust.getName());
				ps.setString(3, cust.getAddress());
				
				System.out.println(ps.executeUpdate()+ "명 회원 등록!!");
			}else {
				//예외 발생... throw new DuplicateIDEException()
				System.out.println(cust.getName() + "님은 이미 회원이셔용~~~");
			}
			
			
		}finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public void delelteCustom(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			String query = "SELECT id FROM custom WHERE id=?";
			ps = conn.prepareStatement(query);
		
			
		}finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public void updateCustom(Custom cust) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			String query = "SELECT id FROM custom WHERE id=?";
			ps = conn.prepareStatement(query);
		
			
		}finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public Custom getCustomer(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Custom> getAllCustomer() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
