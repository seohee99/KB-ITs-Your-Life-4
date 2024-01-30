package web.controller;

public class UpdateController  implements Controller{

	@Override
	public String handleRequest() {
		/* 
		 * Controller의 역할 
		 * 1. 폼값 받아서
		 * 2. vo 생성
		 * 3. DAO 리턴 받음
		 * 4. biz logic 호출
		 * 5. 네비게이션
		 * 
		 * MVC(Servlet마다), FrontController(method 단위마다)했었음
		 * Factory Method Controller(interface 상속받은 java class : component(interface 상속받아 재사용성이 높아진 class))  
		 */
		System.out.println("UpdateController..Update Member..");
		return "update_result.jsp";
	}

}
