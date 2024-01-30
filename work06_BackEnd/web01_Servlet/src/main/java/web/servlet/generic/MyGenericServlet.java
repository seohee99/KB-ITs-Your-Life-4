package web.servlet.generic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * MyGenericServlet 클래스는 자바 기반으로 만들어진 클래스
 * Java Class --- JVM(Platform)
 * Servlet --- Container(WAS, Engine)
 * 
 * ::
 * 
 * MyGenericServlet ms = new MyGenericServlet(); 
 * 객체 생성의 주체가 container로 넘어감!!!!!!! -> enterprise급
 */
public class MyGenericServlet extends GenericServlet{

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// 웹 브라우저로 응답을 하기 위한 객체..
		PrintWriter out = response.getWriter();
		
		out.println("<html><body><h2>");
		out.println("Hello Generic Servlet~~!!");
		out.println("</h2><body></html>");
		
		out.close();
		// 서버가 닫혔다 == 클라이언트 응답이 끝났다, thread, request, response 객체는 메모리에서 내려온다.
		
	}

}
