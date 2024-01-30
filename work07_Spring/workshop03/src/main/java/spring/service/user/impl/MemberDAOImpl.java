package spring.service.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "MemberMapper.";
	
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		System.out.println("::" + getClass().getName() + ".setSqlSession()...");
	}

	@Override
	public int registerMember(MemberVO member) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME + "registerMember", member);
		return result;
	}

	@Override
	public int deleteMember(String member) throws Exception {
		int result = sqlSession.delete(MAPPER_NAME + "deleteMember", member);
		return result;
	}

	@Override
	public int updateMember(MemberVO member) throws Exception {
		int result = sqlSession.update(MAPPER_NAME + "updateMember", member);
		return result;
	}

	@Override
	public List<MemberVO> showAllMember() throws Exception {
		List<MemberVO> result = sqlSession.selectList(MAPPER_NAME + "showAllMember");
		return result;
	}

	@Override
	public MemberVO getMember(String member) throws Exception {
//		MemberVO result = sqlSession.selectOne(MAPPER_NAME + "getMember", member);
//		return result;
		
		return (MemberVO)sqlSession.selectOne(MAPPER_NAME + "getMember", member);
	}

	@Override
	public String idExist(String member) throws Exception {
		String result = sqlSession.selectOne(MAPPER_NAME + "idExist", member);
		return result;
	}

	@Override
	public MemberVO login(MemberVO member) throws Exception {
		MemberVO result = sqlSession.selectOne(MAPPER_NAME + "login", member);
		return result;
	}

}
