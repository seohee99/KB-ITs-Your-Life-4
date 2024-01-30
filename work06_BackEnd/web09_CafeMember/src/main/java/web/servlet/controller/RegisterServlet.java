package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doProcess(request, response);
	  }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      doProcess(request, response);
	  }
	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      request.setCharacterEncoding("utf-8");
	      response.setContentType("text/html;charset=utf-8");
	      // 로직
	      /*
	       * 1. 폼값 받아서
	       * 2. VO 생성
	       * 3. DAO 리턴받고 비즈니스 로직 호ㅜ출
	       * 4. (바인딩?)
	       * 5. 네비게이션 register_result.jsp
	       */
	      System.out.println("...진입...");
	      String id = request.getParameter("id");
	      String password = request.getParameter("password");
	      String name = request.getParameter("name");
	      String address = request.getParameter("address");
	      
	      MemberVO pvo = new MemberVO(id, password, name, address);
	      System.out.println("pvo :: "+pvo);
	     // String path= "index.html";
	      try {
			MemberDAOImpl.getInstance().registerMember(pvo);
			System.out.println("입력성공...");
			//path = "register_result.jsp";
		} catch (Exception e) {
		}
	      request.getRequestDispatcher("register_result.jsp").forward(request, response);
	  }

}
