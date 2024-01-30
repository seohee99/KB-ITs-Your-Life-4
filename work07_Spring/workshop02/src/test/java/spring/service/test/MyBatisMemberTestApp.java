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
		MemberVO member = new MemberVO("Id#01", "PW#01","Name#01" , "Address#01");
		MemberVO member2 = new MemberVO("Id#02", "PW#02","Name#02" , "Address#02");
		MemberVO member3 = new MemberVO("Id#03", "PW#03","Name#03" , "Address#03");
		MemberVO member4 = new MemberVO("Id#04", "PW#04","Name#04" , "Address#04");
		MemberVO member5 = new MemberVO("Id#05", "PW#05","Name#05" , "Address#05");
		MemberVO member6 = new MemberVO("Id#06", "PW#06","Name#06" , "Address#06");
		MemberVO member7 = new MemberVO("Id#07", "PW#07","Name#07" , "Address#07");
//		Object obj = session.insert("MemberMapper.registerMember", member7);
//		session.commit();
//		
//		System.out.println("registerMember :: result " + obj + "\n");
		
		// 1. deleteMember(id:Id#07인 member7 삭제)
		int deleteResult = session.delete("MemberMapper.updateMember", "Id#07");
		session.commit();
		System.out.println("deleteMember :: result "+ deleteResult + "\n");
		
		// 2. updateMember(member7의 address 수정)
		member7.setAddress("성수동");
		int updateResult = session.update("MemberMapper.updateMember", member7);
		session.commit();
		System.out.println("updateMember :: result "+ updateResult + "\n");
		
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
		MemberVO loginResult = (MemberVO) session.selectOne("MemberMapper.login", member6);
		if(loginResult != null) System.out.println("login :: result "+ member6.getName()+ " 로그인 성공. \n");

	}

}
