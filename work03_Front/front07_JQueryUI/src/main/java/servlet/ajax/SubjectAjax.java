package servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SubjectAjax")
public class SubjectAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SubjectAjax() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 진입!!");
		String result = "JAVA | JDBC | Bootstrap | Spring Framework | AI";
		
		request.setAttribute("result", result); // data binding
		
		request.getRequestDispatcher("Result.jsp").forward(request, response);
	}

}
