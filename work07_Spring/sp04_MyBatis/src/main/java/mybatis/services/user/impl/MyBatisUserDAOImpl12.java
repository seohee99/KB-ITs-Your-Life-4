package mybatis.services.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.services.domain.User;
import mybatis.services.user.UserDAO;

public class MyBatisUserDAOImpl12 implements UserDAO {
	
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "UserMapper10.";
	
	// DI...완성
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println("::" + getClass().getName() + ".setSqlSession()...");
	}

	@Override
	public int addUser(User user) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME + "addUser", user);
//		sqlSession.commit();
		return result;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int result = sqlSession.update(MAPPER_NAME + "updateUser", user);
//		sqlSession.commit();
		return result;
	}

	@Override
	public int removeUser(String user) throws Exception {
		int result = sqlSession.delete(MAPPER_NAME + "removeUser", user);
//		sqlSession.commit();
		return result;
	}

	@Override
	public User getUser(String user) throws Exception {
		User result = sqlSession.selectOne(MAPPER_NAME + "getUser", user);
//		sqlSession.commit();
		return result;
	}

	@Override
	public List<User> getUserList(User user) throws Exception {
		List<User> result = sqlSession.selectList(MAPPER_NAME + "getUserList", user);
//		sqlSession.commit();
		return result;
	}

}
