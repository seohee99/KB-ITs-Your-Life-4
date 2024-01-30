package servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberDAOImpl;
import servlet.model.MemberVO;

public class LogoutController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.jsp";
		try {
			// 세션을 죽이는 로직...invalidate()
			HttpSession session = request.getSession();
			if(session.getAttribute("vo")!=null) { // 로그인 된 상태
				session.invalidate();
				path = "logout.jsp";
			}
		} catch (Exception e) {
		}
		return new ModelAndView(path);
	}

}
