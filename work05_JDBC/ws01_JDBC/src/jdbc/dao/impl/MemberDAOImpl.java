package jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import jdbc.dao.MemberDAO;
import jdbc.dto.Member;
import jdbc.exception.DuplicateIDException;
import jdbc.exception.RecordNotFoundException;

public class MemberDAOImpl implements MemberDAO{

	private static MemberDAOImpl dao = new MemberDAOImpl();
	
	private MemberDAOImpl() {}
	
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	
	////////// Common Logic

	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER_NAME, ServerInfo.PASSWORD);
		System.out.println("DB Connect....");
		
		return conn;
	}
	
	public void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs != null) rs.close();
		closeAll(conn, ps);
	}

	////////// Business Logic
	private boolean idExists(int id)throws SQLException{
		Connection conn = getConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String query = "SELECT id FROM member WHERE id=?";
			ps=  conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			return rs.next();
		}finally {
			closeAll(conn,ps,rs);
		}
		
	}
	
//	private int getId(Connection conn) throws SQLException {
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String query = "SELECT seq_id.nextVal FROM dual";
//
//        rs = conn.prepareStatement(query).executeQuery();
//        rs.next();
//        
//        return rs.getInt(1);
//    }
	
	@Override
	public void insertMember(Member m) throws SQLException, DuplicateIDException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {	
			conn = getConnect();
			if(!idExists(m.getId())) {
				String query = "INSERT INTO member (id, name, email, phone) VALUES (seq_id.nextVal, ?, ?, ?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1,m.getName());
				ps.setString(2,m.getEmail());
				ps.setString(3,m.getPhone());
				
				System.out.println(ps.executeUpdate() + " 명 회원 생성 완료");
			}else {
				throw new DuplicateIDException("[insertMember] Duplicated id....");
			}
		}finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public void deleteMember(int id) throws SQLException, RecordNotFoundException {	
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			if(idExists(id)) {
				String query = "DELETE member WHERE id=?";
				ps = conn.prepareStatement(query);
				
				ps.setInt(1, id);
				
				System.out.println(ps.executeUpdate() + "명 삭제 완료");
			}else {
				throw new RecordNotFoundException("[deleteMember] Record Not Found....");
			}
		}finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public void updateMember(Member m) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			if(idExists(m.getId())) {
				String query = "UPDATE member SET name=?, email=?, phone=? WHERE id=?";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, m.getName());
				ps.setString(2, m.getEmail());
				ps.setString(3, m.getPhone());
				ps.setInt(4, m.getId());
				
				System.out.println(ps.executeUpdate() + "명 회원 업데이트 완료");
			}else {
				throw new RecordNotFoundException("[updateMember] Record Not Found....");
			}
		}finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public Member getMember(int id) throws SQLException, RecordNotFoundException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT * FROM member WHERE id=?";
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next())
				return new Member(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
			else
				throw new RecordNotFoundException("[getMember] Record Not Found...");
			
		}finally {
			closeAll(conn, ps, rs);
		}
		
	}

	@Override
	public ArrayList<Member> getMember() throws SQLException {
		ArrayList<Member> temp = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT * FROM member";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) 
				temp.add(new Member(rs.getInt("id"),rs.getString("name"),rs.getString("email") ,rs.getString("phone")));
			
			return temp;
		}finally {
			closeAll(conn, ps, rs);
		}
	}

	@Override
	public ArrayList<Member> getMember(String id) throws SQLException {
		ArrayList<Member> temp = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT * FROM member WHERE name=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) 
				temp.add(new Member(rs.getInt("id"),rs.getString("name"),rs.getString("email") ,rs.getString("phone")));
			
			return temp;
		}finally {
			closeAll(conn, ps, rs);
		}
	}

}
