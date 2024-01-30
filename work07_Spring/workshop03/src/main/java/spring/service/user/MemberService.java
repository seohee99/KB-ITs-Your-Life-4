package spring.service.user;

import java.util.List;

import spring.service.domain.MemberVO;
// 데이터 가공과 관련된 레이저..
// 게시판 페이징 처리 로직, 통계 관련 로직, 알고리즘 연결 로직 등등!
public interface MemberService {
	void registerMember(MemberVO member) throws Exception;
	void updateMember(MemberVO member) throws Exception;
	
	List<MemberVO> showAllMember() throws Exception;
	MemberVO getMember(String member) throws Exception;
	String idExist(String member) throws Exception;
	MemberVO login(MemberVO member) throws Exception;
}
