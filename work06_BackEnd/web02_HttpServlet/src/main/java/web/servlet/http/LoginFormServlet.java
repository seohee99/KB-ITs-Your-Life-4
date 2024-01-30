package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * annotation :: @WebServlet("/LFS")과 같은 내용
 * web.xml(일종의 주문서)
 * <servlet>
 * 		<servlet-name>LoginFormServlet</servlet-name>
 * 		<servlet-class>web.servlet.http.LoginFormServlet</servlet-class>
 * <servlet>
 * 
 * 
 * <servlet-mapping>
 * 		<servlet-name>LoginFormServlet</servlet-name>
 * 		<url-pattern> /LFS </url-pattern>
 * <servlet-mapping>
 * 
 */

// annotation : xml mapping 정보를 짧게 줄임
@WebServlet("/LFS")
public class LoginFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로직은 여기서 작성!!
		// 한글처리는 무조건 PrintWriter 리턴받기 전에 작성해야한다, 양방향 다 해줘야 한다
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 1. 폼 값을 받는다
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. 비즈니스 로직을 호출.... (했다치고)
		// Member member = MemberDAOImpl.getInstance().login(id,password); 이 코드가 동작했다 치고
		
		
		// 3. 반환된 값을 다시 클라이언트로 응답
		// 화며에 출력하는 기능을 가지고 있는 객체를 리턴 받고, response를 통해서
		PrintWriter out = response.getWriter(); 
		out.println("<html><body>");
		out.println("<ul><li> ID : " + id + "</li>");
		out.println("<li> PASSWORD : " + password + "</li>");
		out.println("</ul></body></html>");
		
	}

	
	
}
