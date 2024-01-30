package spring.service.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;

public class MyBatisMemberTestApp {

	public static void main(String[] args) throws Exception {
		Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = factory.openSession();
		
		// 0. registerMember
		MemberVO member = new MemberVO("Id#10", "PW#10","Name#10" , "Address#10");
		System.out.println("registerMember :: result " + session.insert("MemberMapper.registerMember", member));
		session.commit();
		
		
		// 1. deleteMember(id:Id#10인 member7 삭제)
//		int deleteResult = session.delete("MemberMapper.updateMember", "Id#10");
//		session.commit();
//		System.out.println("deleteMember :: result "+ deleteResult + "\n");
//		
		// 2. updateMember(member7의 address 수정)
		member.setAddress("당산동");
		System.out.println("updateMember :: result "+ session.update("MemberMapper.updateMember", member));
		session.commit();
		
		// 3. showAllMember
		System.out.println(":: showAllMember ::");
		List<MemberVO> list = session.selectList("MemberMapper.showAllMember");
		for (MemberVO i : list) System.out.println(i);
		
		// 4. getMember
		String name = (String) session.selectOne("MemberMapper.getMember", "Id#02");
		System.out.println("getMember :: result "+ name + "\n");
				
		
		// 5. idExist
		String id = (String) session.selectOne("MemberMapper.idExist", "Id#05");
		if(id != null) System.out.println("idExist :: result "+ id + "존재합니다. \n");
		else System.out.println("idExist :: result id가 존재하지 않습니다 \n");
		
		
		// 6. login
		MemberVO loginResult = (MemberVO) session.selectOne("MemberMapper.login", member);
		if(loginResult != null) System.out.println("login :: result "+ member.getName()+ " 로그인 성공. \n");

	}

}
