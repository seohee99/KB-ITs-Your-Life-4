package servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JQueryAjax")
public class JQueryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public JQueryAjax() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); // 이 값을 가지고 디비 왔다갔다~~치고.. 로직이 돌아갔다~~치고
		
		/*
		 * 클라이언트로 응답하기 저너 시간을 고의적으로 지연시키겠다
		 */
		
		try {
			Thread.sleep(1000); // 1초 동안 프로그램을 멈춘다...응답이 1초간 지연
		}catch(InterruptedException e) {
			
		}
		
		PrintWriter out = response.getWriter();
		out.print(id);
	}

}
