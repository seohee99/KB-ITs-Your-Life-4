package spring.service.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;
@Service
public class MyBatisMemberServiceTestApp {
	@Autowired
	public static void main(String[] args) throws Exception {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {	"/bean/userservice.xml"	 });
		
		
		MemberService memberService = (MemberService)context.getBean("memberServiceImpl");
		MemberDAO dao = (MemberDAO)context.getBean("memberDAOImpl");
		
		// 0. registerMember
		MemberVO member = new MemberVO("Id#777", "PW#777","Name#777" , "Address#777");
		
//		memberService.registerMember(member);
//		System.out.println(member.getName() + "register");
		

		// 1. updateMember(member7의 address 수정)
		member.setAddress("성수동");
		memberService.updateMember(member);
		System.out.println("updateMember ::");
		
		// 2. showAllMember
		System.out.println(":: showAllMember ::");
		List<MemberVO> list = memberService.showAllMember();
		for (MemberVO i : list) System.out.println(i);
		
		// 3. getMember
		member = memberService.getMember("Id#777");
		System.out.println("getMember :: result "+ member + "\n");
				
		
		// 4. idExist
		String id = "Id#777";
		if( memberService.idExist(id) != null) System.out.println(id + "존재합니다!");
		
		// 5. login
		if(memberService.login(member) != null) System.out.println("login :: result "+ member.getName()+ " 로그인 성공. \n");

	}

}
