package spring.service.user;

import java.util.List;

import spring.service.domain.MemberVO;
/*
 * ~mapping.xml 에서 쿼리문 id 값이 해당 인퍼페이스 기능의 이름이 된다
 */
public interface MemberDAO {
	int registerMember(MemberVO member) throws Exception;
	int deleteMember(String member) throws Exception;
	int updateMember(MemberVO member) throws Exception;
	
	List<MemberVO> showAllMember() throws Exception;
	MemberVO getMember(String member) throws Exception;
	String idExist(String member) throws Exception;
	MemberVO login(MemberVO member) throws Exception;
	
}
