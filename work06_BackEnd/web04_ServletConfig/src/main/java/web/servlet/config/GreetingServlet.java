package web.servlet.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 화면은 요청 시점에서 값을 주기 때문에, 값 요청 전인 초기화 시점에서는 컨테이너 차원의 정보를 세팅해야한다
	private String greet; 

    public GreetingServlet() {
    	System.out.println("1. GreetingServlet 디폴트로 생성");
    }
    
    @Override
    public void init() throws ServletException {
    	System.out.println("2. GreetingServlet 필드 초기화");
    	greet = getInitParameter("GREET");
    	System.out.println("Greet Message : " + greet);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글처리..로직은 여기서 작성..클라이언트 요청 시점에 호출...폼값 받아온다
		request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        
        System.out.println("3 dpProcess... 클라이언트 요청시 동작함");
        String name = request.getParameter("name");
        
        PrintWriter out = response.getWriter();
        // name : 클라이언트 요청 시 받아온 값, 폼값 받아서 한번에 출력
        out.println("<body><h3> " + name + ", " + greet + "</h3></body>");
	}

}
