package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ParameterServlet() {
        System.out.println("LifeCycleServlet() is called!!");
    }

    @Override
	public void init() throws ServletException {
		System.out.println("init() is called!!");
	}
    @Override
	public void destroy() {
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        String job = request.getParameter("job");
        String pageNo = request.getParameter("pageNo");
        String searchWord = request.getParameter("searchWord");
        
        PrintWriter out = response.getWriter();
        out.println("<body>");
        out.println("<h2>job : "+ job +  "</h2>");
        out.println("<h2>pageNo : "+ pageNo +  "</h2>");
        out.println("<h2>searchWord : "+ searchWord +  "</h2>");
        out.println("</body>");
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글처리
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String[] hobby = request.getParameterValues("hobby");
        System.out.println(hobby);
        String favorite = request.getParameter("favorite");
        String desc = request.getParameter("desc");
        
        PrintWriter out = response.getWriter();
        out.println("<body>");
        out.println("<h2>name : "+ name +  "</h2>");
        out.println("<h2>email : "+ email +  "</h2>");
        out.println("<h2>gender : "+ gender +  "</h2>");
        
        String hobbyResult = "";
        for(int i=0; i<hobby.length; i++) {
        	if(i==hobby.length-1) hobbyResult += hobby[i];
        	else hobbyResult += hobby[i] + ", ";
        }
        out.print("<h2>hobby : " + hobbyResult + "</h2>");
        out.println("<h2>favorite : "+ favorite +  "</h2>");
        out.println("<h2>desc : "+ desc +  "</h2>");
        out.println("</body>");
	}
	
	
}
