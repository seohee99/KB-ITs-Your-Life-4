package spring.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
		System.out.println("::" + getClass().getName());
	}

	public void registerMember(MemberVO member) throws Exception {
		memberDAO.registerMember(member);
	}

	@Override
	public void updateMember(MemberVO member) throws Exception {
		memberDAO.updateMember(member);

	}

	@Override
	public List<MemberVO> showAllMember() throws Exception {
		return memberDAO.showAllMember();
	}

	@Override
	public MemberVO getMember(String member) throws Exception {
		return memberDAO.getMember(member);
	}

	@Override
	public String idExist(String id) throws Exception {
		return memberDAO.idExist(id);

	}

	@Override
	public MemberVO login(MemberVO member) throws Exception {
		return memberDAO.login(member);

	}

}
