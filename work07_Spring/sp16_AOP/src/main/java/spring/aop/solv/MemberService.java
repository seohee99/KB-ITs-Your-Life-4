package spring.aop.solv;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class MemberService {
	
	
	public void register(String name) {
		System.out.println("register...logic...회원 등록 성공"); // core concern 
	}
	
	public void findMember(String id) {
		System.out.println("findMember...logic..회원 검색 성공");
	}
	

}
