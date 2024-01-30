package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * DB 연결과정
 * 1. 서버의 정보를 가지고 있는 Driver를 메모리에 로딩
 * 2. DB Connection
 * 3. PrepareStatement 객체 생성
 * 4. 데이터 바인딩
 */

public class DBConnectionTest1 {
	
	
	public DBConnectionTest1() {
		// jdbc 4단계 작업..
		
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String user = "mykb";
		String pw = "1234";
		
		// 1. Driver Loading
		// FQCN(Full Qualified Class Name)으로 풀네임 넣기
		// Oracle > jdbc > driver > OracleDriver
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loading...Success");
			
			// 2. DB Connection
			Connection conn = DriverManager.getConnection(url, user, pw);
			System.out.println("DB Connection...Success");
			
			// 3. PrepareStatement 객체 생성
			// custom 테이블에 하나의 행을 추가하는 쿼리문
			String query = "INSERT INTO custom (id, name, address) VALUES(?,?,?)";
			PreparedStatement ps =  conn.prepareStatement(query);
			System.out.println("Creating PrepareStatement....");
			
			// ?에 값을 넣는다 : 바인딩
			ps.setInt(1, 20);
			ps.setString(2, "Jane");
			ps.setString(3, "NY");
			
			// 4. 쿼리문 실행
			int result = ps.executeUpdate();
			System.out.println(result);
			
		}catch (ClassNotFoundException e){
			System.out.println("Driver Loading...Fail!!");
		}catch (SQLException e){
			System.out.println("DB Connection...Fail!!");
		}
	};
		

	public static void main(String[] args) {
		new DBConnectionTest1();
	}

}
