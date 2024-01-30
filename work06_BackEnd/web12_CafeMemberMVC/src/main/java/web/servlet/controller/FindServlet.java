package web.servlet.controller;
// controller : front, back 모두 연결
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

@WebServlet("/Find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindServlet() {
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
		
		// 로직 작성
		/*
		 * 1. 폼값 받아서 (frontend 화면과 연결된다)
		 * 2. DAO 리턴받고 비지니스 로직 호출
		 * 3. 반환된 값을 바인딩
		 * 4. 네비게이션.. jsp 결과 페이지로 -> find_ok.jsp
		 */
		
		String id = request.getParameter("id");
		//String path = "find_fail.jsp";
		try {
			MemberVO rvo = MemberDAOImpl.getInstance().findByIdMember(id);
			if(rvo!=null) {
				request.setAttribute("vo", rvo);
				//path = "find_ok.jsp";
			}else {
				
			}
			
		} catch (Exception e) {
		}
		request.getRequestDispatcher("find_ok.jsp").forward(request, response);
		
	}
}
