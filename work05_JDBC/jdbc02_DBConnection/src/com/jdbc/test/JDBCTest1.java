package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class JDBCTest1 {
	
	public JDBCTest1() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		//2
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER_NAME, ServerInfo.PASSWORD);
		System.out.println("2. Database Connection...");
		
		//3 -> 나중에는 함수로 만들어서 호출만 되게!
		// delete :: id 40번 삭제
//		String query = "DELETE custom WHERE id=?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		System.out.println("3. PrepareStatement Creation...");
//		
//		//4
//		ps.setInt(1, 40);
//		
//		int row = ps.executeUpdate(); // 이때 실질적으로 db에서 데이터 삭제 발생, commit 자동(프로그램이라서)
//		System.out.println(row + "ROW DELETE OK");
		
		
		// update :: id 10번 고객의 이름을 James1, 주소를 NY로 수정
//		String query = "UPDATE custom SET name=?, address=? WHERE id=?";
//		PreparedStatement ps = conn.prepareStatement(query);
//		
//		ps.setString(1,"James1");
//		ps.setString(2,"NY");
//		ps.setInt(3, 10);
//		
//		int row = ps.executeUpdate();
//		System.out.println(row + "ROW UPDATE OK");
		
		// select :: custom 테이블에 모든 데이터를 받아서 출력
		String query = "SELECT id, name, address FROM custom";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("address"));
		}
		
		
		rs.close();
		ps.close();
		conn.close();
	}

	public static void main(String[] args) throws SQLException {
		new JDBCTest1();

	}
	//1
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("1. Driver Loading Success..");
		}catch(ClassNotFoundException e){
			System.out.println("1. Driver Loading Fail..");
		}
	}

}
