package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		// 1. Factory 생성.. createController 호출 시 command를 인자값으로 넘긴다
		// 2. Factory가 command 값에 해당하는 FindController 생성.. Controller타입으로 리턴
		
		// 3. Controller 받아서 handleRequest()호출
		// 4. 결과로 ModelAndView 리턴
		
		// 5. 네비게이션
		Controller controller = ControllerFactory.getInstance().createController(command); //1,2
		ModelAndView mv = controller.handleRequest(request, response); // 3, 4
		
		if(mv!=null) {
			if(mv.isRedirect()) response.sendRedirect(mv.getPath());
			else request.getRequestDispatcher(mv.getPath()).forward(request, response);
			
		}
		
	}

}
